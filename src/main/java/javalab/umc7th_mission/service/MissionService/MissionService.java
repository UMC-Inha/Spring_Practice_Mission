package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
        // 1. Member와 Mission 조회
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(MEMBER_NOT_FOUND));

        // 2. 이미 도전 중인지 확인
        boolean isAlreadyChallenging = memberMissionRepository.existsByMemberIdAndMissionIdAndStatus(
                memberId, missionId, MissionStatus.CHALLENGING
        );

        if (isAlreadyChallenging) {
            throw new GeneralException(_FORBIDDEN);
        }

        // 3. MemberMission 객체 생성 및 저장
        MemberMission memberMission = MemberMission.create(member, mission, MissionStatus.CHALLENGING);
        memberMissionRepository.save(memberMission);
    }
}