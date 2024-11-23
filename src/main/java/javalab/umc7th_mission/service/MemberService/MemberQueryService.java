package javalab.umc7th_mission.service.MemberService;

import javalab.umc7th_mission.domain.Member;

public interface MemberQueryService {
    Member findMember(Long memberId);
}
