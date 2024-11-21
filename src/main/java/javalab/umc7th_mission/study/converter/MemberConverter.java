package javalab.umc7th_mission.study.converter;

import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.web.dto.member.MemberRequestDTO;
import javalab.umc7th_mission.study.web.dto.member.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){
        return Member.builder()
                .name(request.getName())
                .birth(request.getBirth())
                .address(request.getAddress())
                .memberFoodList(new ArrayList<>())
                .build();
    }
}
