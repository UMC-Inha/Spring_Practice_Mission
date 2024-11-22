package umc.study.service.MemberMissionService;

import umc.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionQueryService {

//    Optional<MemberMission> findMemberMission(Long id);
    List<MemberMission> findMemberMissionsByMemberId(Long id);
}
