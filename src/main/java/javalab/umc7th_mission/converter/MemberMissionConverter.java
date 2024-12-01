package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.web.dto.member_mission.MemberMissionResponseDTO;
import javalab.umc7th_mission.web.dto.mission.MissionResponseDTO;
import javalab.umc7th_mission.web.dto.store.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.SaveResultDTO toSaveResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.SaveResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionId(memberMission.getMission().getId())
                .memberId(memberMission.getMember().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMissionResponseDTO.DoneResultDTO toDoneResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.DoneResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionId(memberMission.getMission().getId())
                .memberId(memberMission.getMember().getId())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static MemberMissionResponseDTO.MissionPreviewDTO missionPreviewDTO(Mission mission) {

        return MemberMissionResponseDTO.MissionPreviewDTO.builder()
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberMissionResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<MemberMission> memberMissionList) {
        List<Mission> missionList = memberMissionList.stream()
                .map(mm -> mm.getMission()).collect(Collectors.toList());
        List<MemberMissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(MemberMissionConverter::missionPreviewDTO).collect(Collectors.toList());

        return MemberMissionResponseDTO.MissionPreviewListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(missionPreviewDTOList.size())
                .missionList(missionPreviewDTOList)
                .build();
    }
}
