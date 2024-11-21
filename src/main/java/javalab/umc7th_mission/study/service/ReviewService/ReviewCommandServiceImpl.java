package javalab.umc7th_mission.study.service.ReviewService;

import javalab.umc7th_mission.study.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.study.apiPayload.exception.GeneralException;
import javalab.umc7th_mission.study.converter.ReviewConverter;
import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.domain.Review;
import javalab.umc7th_mission.study.repository.MemberRepository.MemberRepository;
import javalab.umc7th_mission.study.repository.RestaurantRepository.RestaurantRepository;
import javalab.umc7th_mission.study.repository.ReviewRepository.ReviewRepository;
import javalab.umc7th_mission.study.web.dto.review.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Review addReview(ReviewRequestDTO .AddReviewDto request){
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND));

        Review  newReview = ReviewConverter.toReview(request, member, restaurant);

        return reviewRepository.save(newReview);
    }
}
