package javalab.umc7th_mission.study.web.dto.member_mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MemberMissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMemberMissionResultDTO{
        Long memberMissionId;
        LocalDate createdAt;
    }
}
