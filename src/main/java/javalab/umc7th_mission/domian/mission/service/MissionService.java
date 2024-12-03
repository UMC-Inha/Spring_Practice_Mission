package javalab.umc7th_mission.domian.mission.service;

import javalab.umc7th_mission.domian.membermission.MemberMission;
import javalab.umc7th_mission.domian.mission.Mission;
import javalab.umc7th_mission.domian.mission.dto.MissionRequest;
import javalab.umc7th_mission.domian.mission.dto.MissionResponse;

public interface MissionService {
 public Mission addMission(MissionRequest.AddMission request, Long restaurantId);

 public MemberMission activeMission(MissionRequest.ActiveMission request);
 public MissionResponse.ActiveMissionList getActiveMissionList(Long memberId, Integer page);
 public MemberMission completeMission(Long mmId);
}
