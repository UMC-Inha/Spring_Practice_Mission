package javalab.umc7th_mission.domian.review.service;

import jakarta.transaction.Transactional;
import javalab.umc7th_mission.apipayload.code.status.ErrorStatus;
import javalab.umc7th_mission.apipayload.exception.GeneralException;
import javalab.umc7th_mission.domian.member.Member;
import javalab.umc7th_mission.domian.member.repository.MemberRepository;
import javalab.umc7th_mission.domian.member.service.MemberService;
import javalab.umc7th_mission.domian.review.Review;
import javalab.umc7th_mission.domian.review.dto.ReviewConverter;
import javalab.umc7th_mission.domian.review.dto.ReviewRequestDTO;
import javalab.umc7th_mission.domian.review.repository.ReviewRepository;
import javalab.umc7th_mission.domian.store.Store;
import javalab.umc7th_mission.domian.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewConverter reviewConverter;
    private final MemberService memberService;

    @Transactional
    public Review addReview(Long storeId, ReviewRequestDTO.AddReview request) {
        Store store = storeRepository.findById(storeId).orElseThrow(
            () -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND_BY_ID)
        );
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(
            () -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND)
        );
        Review review = reviewConverter.toEntity(request, member, store);
        reviewRepository.save(review);
        store.getReviewList().add(review);

        return review;
    }

    public Page<Review> getMyReview(Long memberId, Pageable pageable) {
        Member member = memberService.findMember(memberId);
        return reviewRepository.findAllByMember(member,pageable);
    }
}
