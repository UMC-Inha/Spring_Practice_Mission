package javalab.umc7th_mission.domain.review.dto;

import java.time.LocalDate;
import java.util.List;

public final class ReviewResponse {

    private ReviewResponse() {
    }

    public record ReviewsDTO(
            List<ReviewDTO> reviews
    ) {

    }

    public record ReviewDTO(
            String nickname,
            Double score,
            String body,
            LocalDate createdAt
    ) {

    }
}
