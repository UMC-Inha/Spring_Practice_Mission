package javalab.umc7th_mission.service.MemberMissionService;

import javalab.umc7th_mission.domain.mapping.MemberMission;

public interface MemberMissionCommandService {
    MemberMission start(Long memberId, Long missionId);
    Boolean isExist(Long memberId, Long missionId);
}
