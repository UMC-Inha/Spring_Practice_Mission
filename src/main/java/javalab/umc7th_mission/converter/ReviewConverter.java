package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Restaurant;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.web.dto.request.ReviewRequestDTO;
import javalab.umc7th_mission.web.dto.response.ReviewResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {

    public Review toEntity(ReviewRequestDTO.AddReview request, Member member, Restaurant restaurant) {
        return Review.builder()
                .member(member)
                .restaurant(restaurant)
                .content(request.getContent())
                .score(request.getScore())
                .build();
    }

    public ReviewResponseDTO.addReview toAddReviewResponse(Review review) {
        return ReviewResponseDTO.addReview.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreateAt())
                .build();
    }
}
