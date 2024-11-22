package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.web.dto.ReviewRequestDTO;
import javalab.umc7th_mission.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.AddResultDTO toAddResultDTO(Review review) {
        return new ReviewResponseDTO.AddResultDTO(
                review.getId(),
                review.getCreatedAt()
        );
    }

    public static Review toReview(Member member, Store store, ReviewRequestDTO.AddDTO request) {
        return Review.builder()
                .member(member)
                .store(store)
                .content(request.getContent())
                .rating(request.getRating())
                .reviewImageList(request.getReviewImageList())
                .build();
    }
}