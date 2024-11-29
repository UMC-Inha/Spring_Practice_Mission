package javalab.umc7th_mission.domain.member.dto;

import java.time.LocalDateTime;

public final class MemberResponse {

    private MemberResponse() {
    }

    public record JoinResultDTO(
            Long memberId,
            LocalDateTime createdAt
    ) {

    }

}
