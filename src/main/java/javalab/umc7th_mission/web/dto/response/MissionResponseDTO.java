package javalab.umc7th_mission.web.dto.response;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMission{
        Long missionId;
        Long restaurantId;
        LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActiveMission{
        Long missionId;
        LocalDateTime deadline;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionInfo {
        String restaurantName;
        Long restaurantId;
        String content;
        Long reward;
        LocalDateTime deadline;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActiveMissionList{
        List<MissionInfo> missionInfos;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompleteMission {
        Long memberId;
        Long missionId;
        Status status;
    }

}
