package javalab.umc7th_mission.study.web.dto.mission;

import jakarta.validation.constraints.NotNull;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.validation.annotation.ExistRestaurant;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class AddMissionDto{

        @NotNull(message = "미션 이름은 필수 항목입니다.")
        String name;

        @NotNull(message = "미션 내용은 필수 항목입니다.")
        String content;

        @NotNull(message = "미션 포인트는 필수 항목입니다.")
        Integer point;

        @NotNull(message = "미션 마감일은 필수 항목입니다.")
        LocalDate deadline;

        @ExistRestaurant
        Long restaurantId;


    }
}
