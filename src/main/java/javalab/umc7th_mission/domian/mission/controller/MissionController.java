package javalab.umc7th_mission.domian.mission.controller;


import javalab.umc7th_mission.apipayload.ApiResponse;
import javalab.umc7th_mission.domian.mission.dto.MissionRequest;
import javalab.umc7th_mission.domian.mission.dto.MissionResponse;
import javalab.umc7th_mission.domian.mission.dto.MissionResponse.addMissionByStatus;
import javalab.umc7th_mission.domian.mission.repository.MissionRepository;
import javalab.umc7th_mission.domian.mission.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mission")
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/")
    public ApiResponse<addMissionByStatus> ActiveMission(MissionRequest.addMissionByStatusDTO addMissionByStatusDTO){
        addMissionByStatus addMissionByStatus = missionService.ActiveMission(addMissionByStatusDTO);
        return ApiResponse.onSuccess(addMissionByStatus);
    }
}
