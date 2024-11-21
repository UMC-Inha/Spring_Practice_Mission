package javalab.umc7th_mission.web.dto;

import jakarta.validation.constraints.*;
import javalab.umc7th_mission.domain.ReviewImage;
import javalab.umc7th_mission.validation.annotation.ExistStore;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class AddDTO {
        @ExistStore
        private final Long storeId;

        @NotNull(message = "회원 ID는 필수입니다.")
        private final Long memberId;

        @Size(max = 500, message = "리뷰 내용은 최대 500자까지 작성 가능합니다.")
        private final String content;

        @DecimalMin(value = "0.0", inclusive = true, message = "별점은 0.0 이상이어야 합니다.")
        @DecimalMax(value = "5.0", inclusive = true, message = "별점은 5.0 이하이어야 합니다.")
        private final BigDecimal rating;

        private final List<ReviewImage> reviewImageList;

        public AddDTO(
                Long storeId,
                Long memberId,
                String content,
                BigDecimal rating,
                List<ReviewImage> reviewImageList
        ) {
            this.storeId = storeId;
            this.memberId = memberId;
            this.content = content;
            this.rating = rating;
            this.reviewImageList = reviewImageList;
        }

    }
}