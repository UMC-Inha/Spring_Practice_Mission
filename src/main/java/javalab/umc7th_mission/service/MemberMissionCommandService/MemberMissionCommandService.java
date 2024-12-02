package javalab.umc7th_mission.service.MemberMissionCommandService;

import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.web.dto.MemberMissionRequestDTO;
import javalab.umc7th_mission.web.dto.MemberMissionResponseDTO;

public interface MemberMissionCommandService {
    MemberMission addMemberMission(MemberMissionRequestDTO.AddDTO request);

    boolean isMissionInProgress(Long memberId, Long missionId);

    MemberMissionResponseDTO.CompleteMissionResponseDTO completeMission(Long memberId, Long missionId);
}