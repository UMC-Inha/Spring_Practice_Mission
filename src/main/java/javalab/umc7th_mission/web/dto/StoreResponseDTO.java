package javalab.umc7th_mission.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class StoreResponseDTO {
    //해당 클래스 -> 상점 추가시에 사용
    public static class AddResultDTO {
        private final Long storeId;
        private final LocalDateTime createdAt;

        public AddResultDTO(Long storeId, LocalDateTime createdAt) {
            this.storeId = storeId;
            this.createdAt = createdAt;
        }

        // 명시적 Getter (Jackson 직렬화를 위해 필요)
        public Long getStoreId() {
            return storeId;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }
    }


    //@Builder 대신 생성자 직접 주입
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        List<ReviewPreviewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirstPage;
        Boolean isLastPage;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreviewDTO {
        String ownerNickname;
        BigDecimal rating;
        String body;
        LocalDate createdAt;
    }
}