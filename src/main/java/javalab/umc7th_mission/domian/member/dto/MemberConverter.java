package javalab.umc7th_mission.domian.member.dto;

import javalab.umc7th_mission.domian.member.Member;

public class MemberConverter {

    public static MemberResponse.JoinResultDTO toJoinResult(Member member) {
        return MemberResponse.JoinResultDTO.builder()
            .memberId(member.getId())
            .build();
    }

    public static Member toEntity(MemberRequest.JoinDto request) {
        return Member.builder()
            .address(request.getAddress())
            .gender(request.getGender())
            .name(request.getName())
            .point(0)
            .build();

    }
}

