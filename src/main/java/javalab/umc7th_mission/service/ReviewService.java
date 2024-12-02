package javalab.umc7th_mission.service;

import javalab.global.apiPayload.code.status.ErrorStatus;
import javalab.global.apiPayload.exception.GeneralException;
import javalab.umc7th_mission.converter.ReviewConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Restaurant;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.repository.MemberRepository;
import javalab.umc7th_mission.repository.RestaurantRepository;
import javalab.umc7th_mission.repository.ReviewRepository;
import javalab.umc7th_mission.web.dto.request.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final MemberRepository memberRepository;
    private final ReviewConverter reviewConverter;
    private final MemberService memberService;

    @Transactional
    public Review addReview(Long restaurantId, ReviewRequestDTO.AddReview request) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND_BY_ID)
        );
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(
                () -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND)
        );
        Review review = reviewConverter.toEntity(request, member, restaurant);
        reviewRepository.save(review);
        restaurant.getReviewList().add(review);

        return review;
    }

    public Page<Review> getMyReview(Long memberId, Pageable pageable) {
        Member member = memberService.findMember(memberId);
        return reviewRepository.findAllByMember(member,pageable);
    }
}
