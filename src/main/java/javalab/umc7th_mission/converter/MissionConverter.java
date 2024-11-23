package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.web.dto.mission.MissionRequestDTO;
import javalab.umc7th_mission.web.dto.mission.MissionResponseDTO;
import javalab.umc7th_mission.web.dto.review.ReviewRequestDTO;
import javalab.umc7th_mission.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.SaveResultDTO toSaveResultDTO(Mission mission) {
        return MissionResponseDTO.SaveResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.SaveDTO request) {
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }
}
