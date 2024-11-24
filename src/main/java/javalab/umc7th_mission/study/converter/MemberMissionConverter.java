package javalab.umc7th_mission.study.converter;

import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.domain.Mission;
import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import javalab.umc7th_mission.study.web.dto.member_mission.MemberMissionRequestDTO;
import javalab.umc7th_mission.study.web.dto.member_mission.MemberMissionResponseDTO;

import java.time.LocalDate;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.AddMemberMissionResultDTO toAddMemberMissionResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.AddMemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDate.now())
                .build();
    }

    public static MemberMission toMemberMission(Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .startDate(LocalDate.now())
                .build();
    }
}
