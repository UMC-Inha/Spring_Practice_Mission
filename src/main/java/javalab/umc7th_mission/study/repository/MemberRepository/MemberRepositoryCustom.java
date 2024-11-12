package javalab.umc7th_mission.study.repository.MemberRepository;

import javalab.umc7th_mission.study.domain.Member;

public interface MemberRepositoryCustom {
    public Member findMemberById(Long id);
}
