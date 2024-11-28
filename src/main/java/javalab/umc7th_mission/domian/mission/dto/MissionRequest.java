package javalab.umc7th_mission.domian.mission.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionRequest {


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class addMissionByStatusDTO{
        Long missionId;
    }

}
