package javalab.umc7th_mission.domian.mission.service;

import javalab.umc7th_mission.domian.mission.dto.MissionRequest;
import javalab.umc7th_mission.domian.mission.dto.MissionResponse;

public interface MissionService {
 public MissionResponse.addMissionByStatus ActiveMission(MissionRequest.addMissionByStatusDTO addMissionByStatusDTO);
}
