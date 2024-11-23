package javalab.umc7th_mission.web.dto.review;

import javalab.umc7th_mission.validation.annotation.ExistStores;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

public class ReviewRequestDTO {
    @ExistStores
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SaveDTO {
        private String body;
        private BigDecimal score;
        private Long memberId;
        private Long storeId;
    }
}
