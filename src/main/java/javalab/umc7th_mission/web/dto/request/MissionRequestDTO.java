package javalab.umc7th_mission.web.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class MissionRequestDTO {

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
