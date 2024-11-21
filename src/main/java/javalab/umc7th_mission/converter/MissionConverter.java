package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.web.dto.MissionRequestDTO;
import javalab.umc7th_mission.web.dto.MissionResponseDTO;

public class MissionConverter {

    public static MissionResponseDTO.AddResultDTO toAddResultDTO(Mission mission) {
        return new MissionResponseDTO.AddResultDTO(
                mission.getId(),
                mission.getCreatedAt()
        );
    }

    public static Mission toMission(Store store, MissionRequestDTO.AddDTO request) {
        return Mission.builder()
                .store(store)
                .name(request.getName())
                .description(request.getDescription())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .reward(request.getReward())
                .build();
    }
}
