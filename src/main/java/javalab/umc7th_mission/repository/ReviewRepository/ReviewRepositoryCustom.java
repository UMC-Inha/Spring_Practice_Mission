package javalab.umc7th_mission.repository.ReviewRepository;

import javalab.umc7th_mission.domain.Review;
import java.util.List;

public interface ReviewRepositoryCustom {
    void saveReview(String memberName, String storeName, String text, float score);

    List<Review> findReviewsByStore(Long storeId);
}
