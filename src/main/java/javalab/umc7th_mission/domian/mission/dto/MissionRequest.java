package javalab.umc7th_mission.domian.mission.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

public class MissionRequest {

    @Getter
    public static class AddMission {
        @Length(max = 200)
        String content;
        @Min(500)
        Long reward;
    }

    @Getter
    public static class ActiveMission {
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
        @Length(min = 12,max = 12)
        String classificationNumber;
        LocalDateTime deadline;

    }

}
