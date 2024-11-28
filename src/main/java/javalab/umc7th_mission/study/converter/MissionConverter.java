package javalab.umc7th_mission.study.converter;

import javalab.umc7th_mission.study.domain.Mission;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.web.dto.mission.MissionRequestDTO;
import javalab.umc7th_mission.study.web.dto.mission.MissionResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {
    public static MissionResponseDTO.AddMissionResultDTO toAddMissionResultDTO(Mission mission){
        return new MissionResponseDTO.AddMissionResultDTO().builder()
                .missionId(mission.getId())
                .createdAt(LocalDate.now())
                .build();
    }
    public static Mission toMission(MissionRequestDTO.AddMissionDto request, Restaurant restaurant){
        return Mission.builder()
                .name(request.getName())
                .content(request.getContent())
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .restaurant(restaurant)
                .build();
    }

    public static MissionResponseDTO.MissionPreviewDTO missionPreviewDTO(Mission mission){
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .name(mission.getName())
                .content(mission.getContent())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<Mission> missionList){
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(MissionConverter::missionPreviewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionList.getSize())
                .missionList(missionPreviewDTOList)
                .build();

    }
}
