package javalab.umc7th_mission.study.service.MissionService;

import javalab.umc7th_mission.study.domain.Mission;
import javalab.umc7th_mission.study.web.dto.mission.MissionRequestDTO;
import org.springframework.data.domain.Page;

public interface MissionCommandService {
    Mission AddMission(MissionRequestDTO.AddMissionDto request);
    Page<Mission> getMissionList(Long storeId, Integer page);
}
