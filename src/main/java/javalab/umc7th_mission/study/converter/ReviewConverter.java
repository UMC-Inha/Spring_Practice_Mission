package javalab.umc7th_mission.study.converter;

import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.domain.Review;
import javalab.umc7th_mission.study.web.dto.review.ReviewRequestDTO;
import javalab.umc7th_mission.study.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.AddReviewResultDTO toAddReviewResultDTO(Review review) {
        return ReviewResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.AddReviewDto request, Member member, Restaurant restaurant) {
        return Review.builder()
                .score(request.getScore())
                .content(request.getContent())
                .member(member)
                .restaurant(restaurant)
                .build();
    }
}
