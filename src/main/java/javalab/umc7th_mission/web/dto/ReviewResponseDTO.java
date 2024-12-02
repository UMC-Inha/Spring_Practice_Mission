package javalab.umc7th_mission.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    //@Builder 패턴 사용이 미션 조건에 붙어있음...
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewListDTO{
        List<ReviewPreviewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirstPage;
        Boolean isLastPage;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewDTO {
        String ownerNickname;
        String storeName;
        BigDecimal rating;
        String body;
        LocalDate createdAt;
    }
}