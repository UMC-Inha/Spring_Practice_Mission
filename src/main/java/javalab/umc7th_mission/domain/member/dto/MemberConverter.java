package javalab.umc7th_mission.domain.member.dto;

import java.time.LocalDateTime;
import javalab.umc7th_mission.domain.member.Gender;
import javalab.umc7th_mission.domain.member.Member;

public final class MemberConverter {

    private MemberConverter() {
    }

    public static MemberResponse.JoinResultDTO to(Member member) {
        return new MemberResponse.JoinResultDTO(
                member.getId(),
                LocalDateTime.now()
        );
    }

    public static Member to(MemberRequest.JoinDTO request) {
        return Member.builder()
                .address(request.address())
                .specAddress(request.specAddress())
                .gender(Gender.to(request.gender()))
                .name(request.name())
                .age(request.age())
                .build();
    }

}
