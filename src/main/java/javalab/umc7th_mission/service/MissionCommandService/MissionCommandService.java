package javalab.umc7th_mission.service.MissionCommandService;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMission(MissionRequestDTO.AddDTO request);
}