package javalab.umc7th_mission.study.service.MemberMissionService;

import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import javalab.umc7th_mission.study.web.dto.member_mission.MemberMissionRequestDTO;
import org.springframework.data.domain.Page;

public interface MemberMissionCommandService {
    MemberMission AddMemberMission(MemberMissionRequestDTO.AddMemberMissionDto request);
    boolean isExist(Long memberId, Long missionId);
    Page<MemberMission> getChallengingMemberMissionList(Long memberId, Integer page);
}

