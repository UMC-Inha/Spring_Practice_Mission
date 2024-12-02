package javalab.umc7th_mission.service.StoreQueryService;

import javalab.umc7th_mission.domain.Review;
import org.springframework.data.domain.Page;

public interface StoreQueryService {
    Page<Review> getReviewList(Long storeId, Integer page);
}
