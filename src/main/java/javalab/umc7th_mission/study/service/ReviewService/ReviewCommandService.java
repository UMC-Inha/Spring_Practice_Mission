package javalab.umc7th_mission.study.service.ReviewService;

import javalab.umc7th_mission.study.domain.Review;
import javalab.umc7th_mission.study.web.dto.review.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDTO.AddReviewDto request);
}
