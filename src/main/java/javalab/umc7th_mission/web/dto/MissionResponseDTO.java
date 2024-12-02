package javalab.umc7th_mission.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {
    public static class AddResultDTO {
        private final Long missionId;
        private final LocalDateTime createdAt;

        public AddResultDTO(Long missionId, LocalDateTime createdAt) {
            this.missionId = missionId;
            this.createdAt = createdAt;
        }

        // 명시적 Getter (Jackson 직렬화를 위해 필요)
        public Long getMissionId() {
            return missionId;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreviewListDTO{
        List<MissionResponseDTO.MissionPreviewDTO> missionList;
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
    public static class MissionPreviewDTO {

        Long missionId;
        String missionName;
        String description;
        Integer reward;
        boolean isActive;
        LocalDate startDate;
        LocalDate endDate;
    }
}