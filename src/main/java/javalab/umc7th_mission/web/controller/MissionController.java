package javalab.umc7th_mission.web.controller;

import jakarta.validation.Valid;
import javalab.global.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.MissionConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.service.MemberService;
import javalab.umc7th_mission.service.MissionService;
import javalab.umc7th_mission.web.dto.request.MissionRequestDTO;
import javalab.umc7th_mission.web.dto.response.MissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;
    private final MissionConverter missionConverter;


    @PostMapping("/{restaurantId}")
    public ApiResponse<MissionResponseDTO.AddMission> addMission(@PathVariable("restaurantId") Long restaurantId,
                                                                 @RequestBody @Valid MissionRequestDTO.AddMission request){
        Mission mission = missionService.addMission(request, restaurantId);
        MissionResponseDTO.AddMission addMissionResponse = missionConverter.toAddMissionResponse(mission);

        return ApiResponse.onSuccess(addMissionResponse);
    }

    @PostMapping("/active")
    public ApiResponse<MissionResponseDTO.ActiveMission> activeMission(@RequestBody @Valid MissionRequestDTO.ActiveMission request) {
        MemberMission memberMission = missionService.activeMission(request);
        MissionResponseDTO.ActiveMission activeMission = missionConverter.toActiveMission(memberMission);

        return ApiResponse.onSuccess(activeMission);
    }
}
