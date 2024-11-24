package javalab.umc7th_mission.study.converter;

import javalab.umc7th_mission.study.domain.Mission;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.web.dto.mission.MissionRequestDTO;
import javalab.umc7th_mission.study.web.dto.mission.MissionResponseDTO;

import java.time.LocalDate;

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
}
