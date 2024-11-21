package javalab.umc7th_mission.study.service.MemberMissionService;

import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import javalab.umc7th_mission.study.web.dto.member_mission.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    MemberMission AddMemberMission(MemberMissionRequestDTO.AddMemberMissionDto request);
    boolean isChallenging(Long memberId, Long missionId);
}

