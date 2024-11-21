package javalab.umc7th_mission.web.dto;

import java.time.LocalDateTime;

public class MemberMissionResponseDTO {
    public static class AddResultDTO{
        private final Long memberMissionId;
        private final LocalDateTime createdAt;

        public AddResultDTO(Long memberMissionId, LocalDateTime createdAt) {
            this.memberMissionId = memberMissionId;
            this.createdAt = createdAt;
        }

        public Long getMemberMissionId() { return memberMissionId; }
        public LocalDateTime getCreatedAt() { return createdAt; }
    }
}
