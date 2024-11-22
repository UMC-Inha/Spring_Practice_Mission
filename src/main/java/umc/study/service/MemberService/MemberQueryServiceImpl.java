package umc.study.service.MemberService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.repository.MemberRepository.MemberRepository;

import java.util.List;

// MemberQueryServiceImpl.java
@Service
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;

    public MemberQueryServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> findMemberByMemberDetailsId(Long userId) {
        Member member = memberRepository.findMemberDetailsById(userId);
        return member != null ? List.of(member) : List.of();
    }
}
