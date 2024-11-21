package javalab.umc7th_mission.web.dto;

import jakarta.validation.constraints.*;
import javalab.umc7th_mission.validation.annotation.ExistStore;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class AddDTO {
        @ExistStore
        private Long storeId;

        @NotBlank(message = "미션 이름은 필수 항목입니다.")
        @Size(max = 100, message = "미션 이름은 최대 100자까지 입력 가능합니다.")
        private String name;


        @NotBlank(message = "미션 설명은 필수 항목입니다.")
        @Size(max = 500, message = "미션 설명은 최대 500자까지 입력 가능합니다.")
        private String description;

        @NotNull(message = "시작 날짜는 필수 항목입니다.")
        @FutureOrPresent(message = "시작 날짜는 오늘 이후여야 합니다.")
        private LocalDate startDate;

        @NotNull(message = "종료 날짜는 필수 항목입니다.")
        @Future(message = "종료 날짜는 오늘 이후여야 합니다.")
        private LocalDate endDate;

        @NotNull(message = "보상 포인트는 필수 항목입니다.")
        @Min(value = 0, message = "보상 포인트는 0 이상이어야 합니다.")
        private Integer reward;

        public AddDTO(
               Long storeId,
               String name,
               String description,
               LocalDate startDate,
               LocalDate endDate,
               Integer reward
        ) {
            this.storeId = storeId;
            this.name = name;
            this.description = description;
            this.startDate = startDate;
            this.endDate = endDate;
            this.reward = reward;
        }
    }
}
