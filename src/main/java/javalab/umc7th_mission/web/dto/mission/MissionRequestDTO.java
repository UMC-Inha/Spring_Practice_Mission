package javalab.umc7th_mission.web.dto.mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MissionRequestDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SaveDTO {
        private Integer reward;
        private LocalDateTime deadline;
        private String missionSpec;
        private Long storeId;
    }
}
