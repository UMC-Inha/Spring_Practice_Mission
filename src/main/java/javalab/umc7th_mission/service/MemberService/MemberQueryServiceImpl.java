package javalab.umc7th_mission.service.MemberService;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.repository.MemberRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;

    @Override
    public Member findMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return member;
    }

}
