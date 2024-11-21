package javalab.umc7th_mission.web.dto;

import java.time.LocalDateTime;

public class StoreResponseDTO {
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
}
