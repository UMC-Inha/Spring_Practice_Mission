package javalab.umc7th_mission.service.ReviewCommandService;

import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review addReview(ReviewRequestDTO.AddDTO request);
}