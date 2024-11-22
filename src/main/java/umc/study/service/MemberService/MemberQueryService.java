package umc.study.service.MemberService;

import umc.study.domain.Member;

import java.util.List;

public interface MemberQueryService {
    List<Member> findMemberByMemberDetailsId(Long memberId);
}
