package javalab.umc7th_mission.web.dto.member_mission;

import javalab.umc7th_mission.validation.annotation.InProgressMemberMission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class MemberMissionRequestDTO {
    @InProgressMemberMission
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SaveDTO {
        private Long memberId;
        private Long missionId;
    }
}
