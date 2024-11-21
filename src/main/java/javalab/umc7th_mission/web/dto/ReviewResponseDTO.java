package javalab.umc7th_mission.web.dto;

import java.time.LocalDateTime;

public class ReviewResponseDTO {
    public static class AddResultDTO {
        private final Long reviewId;
        private final LocalDateTime createdAt;

        public AddResultDTO(Long reviewId, LocalDateTime createdAt) {
            this.reviewId = reviewId;
            this.createdAt = createdAt;
        }

        // 명시적 Getter (Jackson 직렬화를 위해 필요)
        public Long getReviewId() {
            return reviewId;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }
    }
}
