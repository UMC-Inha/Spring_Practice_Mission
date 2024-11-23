package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.web.dto.review.ReviewRequestDTO;
import javalab.umc7th_mission.web.dto.review.ReviewResponseDTO;
import javalab.umc7th_mission.web.dto.store.StoreRequestDTO;
import javalab.umc7th_mission.web.dto.store.StoreResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.SaveResultDTO toSaveResultDTO(Review review) {
        return ReviewResponseDTO.SaveResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.SaveDTO request) {
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();
    }
}
