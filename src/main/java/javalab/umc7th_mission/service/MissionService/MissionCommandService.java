package javalab.umc7th_mission.service.MissionService;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.web.dto.mission.MissionRequestDTO;

public interface MissionCommandService {
    Mission save(MissionRequestDTO.SaveDTO request);
}
