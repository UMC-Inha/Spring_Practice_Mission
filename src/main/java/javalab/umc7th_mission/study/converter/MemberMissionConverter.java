package javalab.umc7th_mission.study.converter;

import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.domain.Mission;
import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import javalab.umc7th_mission.study.web.dto.member_mission.MemberMissionRequestDTO;
import javalab.umc7th_mission.study.web.dto.member_mission.MemberMissionResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MemberMissionResponseDTO.ChallengingMissionPreviewDTO challengingMissionPreviewDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.ChallengingMissionPreviewDTO.builder()
                .memberId(memberMission.getMember().getId())
                .memberId(memberMission.getMission().getId())
                .name(memberMission.getMission().getName())
                .content(memberMission.getMission().getContent())
                .point(memberMission.getMission().getPoint())
                .start(memberMission.getStartDate())
                .end(memberMission.getEndDate())
                .build();
    }

    public static MemberMissionResponseDTO.ChallengingMissionPreviewListDTO challengingMissionPreviewListDTO(Page<MemberMission> memberMissionlist){
        List<MemberMissionResponseDTO.ChallengingMissionPreviewDTO> challenginMissionList = memberMissionlist.stream()
                .map(MemberMissionConverter::challengingMissionPreviewDTO).collect(Collectors.toList());

        return MemberMissionResponseDTO.ChallengingMissionPreviewListDTO.builder()
                .isFirst(memberMissionlist.isFirst())
                .isLast(memberMissionlist.isLast())
                .totalPage(memberMissionlist.getTotalPages())
                .totalElements(memberMissionlist.getTotalElements())
                .listSize(memberMissionlist.getSize())
                .challengingMissionList(challenginMissionList)
                .build();
    }
}
