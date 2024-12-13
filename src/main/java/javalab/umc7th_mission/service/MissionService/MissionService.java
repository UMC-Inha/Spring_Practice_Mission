package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.MissionRequestDTO;
import umc.spring.dto.MissionResponseDTO;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;

import static umc.spring.apiPayload.code.status.ErrorStatus.MEMBER_NOT_FOUND;
import static umc.spring.apiPayload.code.status.ErrorStatus._FORBIDDEN;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;


    @Transactional
    public MissionResponseDTO addMission(MissionRequestDTO request) {
        // 가게 정보 확인
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store를 찾을 수 없습니다."));

        // Mission 생성 및 저장
        Mission mission = Mission.builder()
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .store(store)
                .status(MissionStatus.COMPLETE)  // status 값 기본 설정
                .build();

        Mission savedMission = missionRepository.save(mission);

        // MissionResponseDTO 반환
        return new MissionResponseDTO(
                savedMission.getId(),
                savedMission.getMissionSpec(),
                savedMission.getReward(),
                savedMission.getDeadline(),
                store.getName()
        );
    }

    @Transactional
    public void startMission(Long memberId, Long missionId) {
        // 1. 회원 및 미션 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(MEMBER_NOT_FOUND));

        // 2. 이미 도전 중인지 확인
        boolean isAlreadyChallenging = memberMissionRepository.existsByMemberIdAndMissionIdAndStatus(
                memberId, missionId, MissionStatus.CHALLENGING
        );
        if (isAlreadyChallenging) {
            throw new GeneralException(MEMBER_NOT_FOUND);
        }

        // 3. 새로운 도전 상태 추가
        MemberMission memberMission = MemberMission.create(member, mission, MissionStatus.CHALLENGING);
        memberMissionRepository.save(memberMission);
    }

    // 특정 가게의 미션 목록 조회
    public Page<MissionResponseDTO> getMissionsByStore(Long storeId, Integer page, Integer size) {
        // Store 유효성 검사
        storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Store를 찾을 수 없습니다."));

        // 페이징 처리
        PageRequest pageable = PageRequest.of(page, size);

        // 미션 목록 조회 및 DTO 변환
        return missionRepository.findByStoreId(storeId, pageable)
                .map(mission -> MissionResponseDTO.builder()
                        .id(mission.getId())
                        .missionSpec(mission.getMissionSpec())
                        .reward(mission.getReward())
                        .deadline(mission.getDeadline())
                        .storeName(mission.getStore().getName())
                        .build());
    }

    @Transactional
    public void completeMission(Long memberId, Long missionId) {
        // 회원-미션 관계 조회
        MemberMission memberMission = memberMissionRepository.findByMemberIdAndMissionId(memberId, missionId)
                .orElseThrow(() -> new GeneralException(MEMBER_NOT_FOUND));

        // 현재 상태 확인 (CHALLENGING 상태여야 완료 가능)
        if (memberMission.getStatus() != MissionStatus.CHALLENGING) {
            throw new GeneralException(MEMBER_NOT_FOUND);
        }

        // 미션 완료 처리
        memberMission.complete();
    }

    @Transactional
    public Page<MissionResponseDTO> getOngoingMissionsByMember(Long memberId, Integer page, Integer size) {
        // 1. 회원 유효성 검사
        memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원을 찾을 수 없습니다."));

        // 2. 페이징 처리
        PageRequest pageable = PageRequest.of(page - 1, size); // Spring Data JPA는 0-based index 사용

        // 3. 진행 중인 미션 조회 및 변환
        return memberMissionRepository.findByMemberIdAndStatus(memberId, MissionStatus.CHALLENGING, pageable)
                .map(memberMission -> {
                    Mission mission = memberMission.getMission();
                    return MissionResponseDTO.builder()
                            .id(mission.getId())
                            .missionSpec(mission.getMissionSpec())
                            .reward(mission.getReward())
                            .deadline(mission.getDeadline())
                            .storeName(mission.getStore().getName())
                            .build();
                });
    }
}