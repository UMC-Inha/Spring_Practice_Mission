package javalab.umc7th_mission.service.MissionService;

import javalab.umc7th_mission.domain.Mission;

public interface MissionQueryService {
    Mission findMission(Long missionId);
}
