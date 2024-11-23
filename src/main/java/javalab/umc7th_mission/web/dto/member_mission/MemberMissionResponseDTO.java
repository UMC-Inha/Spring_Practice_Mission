package javalab.umc7th_mission.web.dto.member_mission;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberMissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SaveResultDTO {
        Long memberMissionId;
        Long memberId;
        Long missionId;
        LocalDateTime createdAt;
    }
}
