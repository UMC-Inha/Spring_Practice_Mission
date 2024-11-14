package javalab.umc7th_mission.repository.MemberRepository;

import javalab.umc7th_mission.domain.Member;

public interface MemberRepositoryCustom {
    public Member findMemberById(Long id);
}
