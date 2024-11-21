package javalab.umc7th_mission.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import javalab.umc7th_mission.validation.annotation.MissionNotInProgress;
import lombok.Getter;

import java.time.LocalDate;

public class MemberMissionRequestDTO {

    @Getter
    public static class AddDTO {
        @NotNull(message = "회원 ID는 필수입니다.")
        private final Long memberId;

        @NotNull(message = "미션 ID는 필수입니다.")
        @MissionNotInProgress
        private final Long missionId;

        @NotNull(message = "시작 날짜는 필수 항목입니다.")
        @FutureOrPresent(message = "시작 날짜는 오늘 이후여야 합니다.")
        private LocalDate startDate;

        @NotNull(message = "종료 날짜는 필수 항목입니다.")
        @Future(message = "종료 날짜는 오늘 이후여야 합니다.")
        private LocalDate endDate;

        public AddDTO(
                Long memberId,
                Long missionId,
                LocalDate startDate,
                LocalDate endDate
        ) {
            this.memberId = memberId;
            this.missionId = missionId;
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }
}
