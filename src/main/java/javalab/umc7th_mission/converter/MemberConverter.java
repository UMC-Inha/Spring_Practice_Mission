package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.web.dto.request.MemberRequestDTO;
import javalab.umc7th_mission.web.dto.response.MemberResponseDTO;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResult(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreateAt())
                .build();
    }

    public static Member toEntity(MemberRequestDTO.JoinDto request) {
        return Member.builder()
                .address(request.getAddress())
                .birth(request.getBirth())
                .gender(request.getGender())
                .name(request.getName())
                .point(0l)
                .build();

    }
}
