package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.dto.MissionResponseDTO;

public class MissionConverter {
    public static MissionResponseDTO toMissionResponseDTO(Mission mission) {
        return MissionResponseDTO.builder()
                .id(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .storeName(mission.getStore().getName())
                .build();
    }
}