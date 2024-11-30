package javalab.umc7th_mission.study.service.ReviewService;

import javalab.umc7th_mission.study.domain.Review;
import javalab.umc7th_mission.study.web.dto.review.ReviewRequestDTO;
import org.springframework.data.domain.Page;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDTO.AddReviewDto request);
    Page<Review> getRestaurantReviewList(Long restaurantId, Integer page);
    Page<Review> getMemberReviewList(Long memberId, Integer page);
}
