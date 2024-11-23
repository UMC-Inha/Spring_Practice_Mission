package javalab.umc7th_mission.service.ReviewService;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.web.dto.review.ReviewRequestDTO;

public interface ReviewCommandService {
    Review save(ReviewRequestDTO.SaveDTO request);
}
