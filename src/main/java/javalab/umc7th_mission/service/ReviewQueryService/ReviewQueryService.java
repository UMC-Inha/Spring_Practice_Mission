package javalab.umc7th_mission.service.ReviewQueryService;

import javalab.umc7th_mission.domain.Review;
import org.springframework.data.domain.Page;

public interface ReviewQueryService {

    Page<Review> getMemberReviews(Long memberId, Integer page);
}
