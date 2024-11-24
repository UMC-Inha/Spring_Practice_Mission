package javalab.umc7th_mission.study.service.MissionService;

import javalab.umc7th_mission.study.domain.Mission;
import javalab.umc7th_mission.study.web.dto.mission.MissionRequestDTO;

public interface MissionCommandService {
    Mission AddMission(MissionRequestDTO.AddMissionDto request);
}
