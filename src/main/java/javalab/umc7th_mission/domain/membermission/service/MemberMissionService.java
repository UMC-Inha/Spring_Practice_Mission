package javalab.umc7th_mission.domain.membermission.service;

import javalab.umc7th_mission.config.apipayload.code.status.ErrorStatus;
import javalab.umc7th_mission.config.apipayload.exception.GeneralException;
import javalab.umc7th_mission.domain.membermission.MemberMission;
import javalab.umc7th_mission.domain.membermission.dto.MemberMissionResponseDTO;
import javalab.umc7th_mission.domain.membermission.repository.MemberMissionRepository;
import javalab.umc7th_mission.domain.mission.MissionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;

    public Page<MemberMissionResponseDTO> getOngoingMissionsByMember(Long memberId,
            Pageable pageable) {
        String status = MissionStatus.CHALLENGING.name();

        return memberMissionRepository.findByMemberIdAndStatus(memberId, status, pageable)
                .map(memberMission -> new MemberMissionResponseDTO(
                        memberMission.getMission().getId(),
                        memberMission.getMission().getMissionSpec(),
                        memberMission.getMission().getReward(),
                        memberMission.getStatus().name(),
                        memberMission.getMission().getStore().getName()
                ));
    }

    @Transactional
    public void completeMission(Long memberId, Long missionId) {
        MemberMission memberMission = memberMissionRepository.findByMemberIdAndMissionId(memberId,
                        missionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));
        if (!memberMission.getStatus().equals(MissionStatus.CHALLENGING)) {
            throw new GeneralException(ErrorStatus._BAD_REQUEST);
        }
        memberMission.complete();
    }
}
