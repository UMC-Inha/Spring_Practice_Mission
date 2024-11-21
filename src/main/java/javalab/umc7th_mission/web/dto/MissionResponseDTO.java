package javalab.umc7th_mission.web.dto;

import java.time.LocalDateTime;

public class MissionResponseDTO {
    public static class AddResultDTO {
        private final Long missionId;
        private final LocalDateTime createdAt;

        public AddResultDTO(Long missionId, LocalDateTime createdAt) {
            this.missionId = missionId;
            this.createdAt = createdAt;
        }

        // 명시적 Getter (Jackson 직렬화를 위해 필요)
        public Long getReviewId() {
            return missionId;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }
    }
}
