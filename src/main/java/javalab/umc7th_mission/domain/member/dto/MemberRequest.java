package javalab.umc7th_mission.domain.member.dto;

import java.util.List;

public final class MemberRequest {

    private MemberRequest() {
    }

    public record JoinDTO(
            String name,
            String gender,
            Integer age,
            Integer birthYear,
            Integer birthMonth,
            Integer birthDay,
            String address,
            String specAddress,
            List<Long> preferCategoryIds
    ) {

    }

}
