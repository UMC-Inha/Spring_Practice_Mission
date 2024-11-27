package javalab.umc7th_mission.web.dto;

import javalab.umc7th_mission.domain.Mission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResponseDTO {
    public static class AddResultDTO{
        private final Long memberMissionId;
        private final LocalDateTime createdAt;

        public AddResultDTO(Long memberMissionId, LocalDateTime createdAt) {
            this.memberMissionId = memberMissionId;
            this.createdAt = createdAt;
        }

        public Long getMemberMissionId() { return memberMissionId; }
        public LocalDateTime getCreatedAt() { return createdAt; }
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengingMissionPreviewListDTO{
        List<ChallengingMissionPreviewDTO> challengingMissionList;
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
    public static class ChallengingMissionPreviewDTO{
        Long memberMissionId;
        Long missionId;
        String missionName;
        String missionDescription;
        Integer reward;
        LocalDate startDate;
        LocalDate endDate;
    }
}