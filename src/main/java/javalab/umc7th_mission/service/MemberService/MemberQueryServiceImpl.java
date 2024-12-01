package javalab.umc7th_mission.service.MemberService;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.repository.MemberRepository.MemberRepository;
import javalab.umc7th_mission.repository.ReivewRepository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Member findMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return member;
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        return reviewRepository.findAllByMemberId(memberId, PageRequest.of(page-1, 10, Sort.by(Sort.Direction.DESC,"createdAt")));
    }
}
