package javalab.umc7th_mission.service.MemberMissionCommandService;

import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.web.dto.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission addMemberMission(MemberMissionRequestDTO.AddDTO request);

    boolean isMissionInProgress(Long memberId, Long missionId);
}