package javalab.umc7th_mission.domian.mission.dto;

import java.time.LocalDateTime;
import java.util.List;
import javalab.umc7th_mission.domian.enums.MissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionResponse {


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMission{
        Long missionId;
        Long storeId;
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
        String storeName;
        Long storeId;
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
        MissionStatus status;
    }

}
