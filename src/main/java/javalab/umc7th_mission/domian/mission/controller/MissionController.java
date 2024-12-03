package javalab.umc7th_mission.domian.mission.controller;


import jakarta.validation.Valid;
import javalab.umc7th_mission.apipayload.ApiResponse;
import javalab.umc7th_mission.domian.membermission.MemberMission;
import javalab.umc7th_mission.domian.mission.Mission;
import javalab.umc7th_mission.domian.mission.dto.MissionConverter;
import javalab.umc7th_mission.domian.mission.dto.MissionRequest;
import javalab.umc7th_mission.domian.mission.dto.MissionResponse;
import javalab.umc7th_mission.domian.mission.service.MissionService;
import javalab.umc7th_mission.validation.annotation.CheckPage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mission")
public class MissionController {

    private final MissionService missionService;
    private final MissionConverter missionConverter;


    @PostMapping("/{restaurantId}")
    public ApiResponse<MissionResponse.AddMission> addMission(@PathVariable("restaurantId") Long restaurantId,
        @RequestBody @Valid MissionRequest.AddMission request) {
        Mission mission = missionService.addMission(request, restaurantId);
        MissionResponse.AddMission addMissionResponse = missionConverter.toAddMissionResponse(mission);

        return ApiResponse.onSuccess(addMissionResponse);
    }

    @PostMapping("/active")
    public ApiResponse<MissionResponse.ActiveMission> activeMission(@RequestBody @Valid MissionRequest.ActiveMission request) {
        MemberMission memberMission = missionService.activeMission(request);
        MissionResponse.ActiveMission activeMission = missionConverter.toActiveMission(memberMission);

        return ApiResponse.onSuccess(activeMission);
    }

    @GetMapping("/active/{memberId}")
    public ApiResponse<MissionResponse.ActiveMissionList> activeMissionList(@PathVariable(name = "memberId") Long memberId,
        @CheckPage @RequestParam(name = "page") Integer page) {

        MissionResponse.ActiveMissionList activeMissionList = missionService.getActiveMissionList(memberId, page);

        return ApiResponse.onSuccess(activeMissionList);
    }

    @PatchMapping("/{memberMissionId}")
    public ApiResponse<MissionResponse.CompleteMission> completeMission(@PathVariable(name = "memberMissionId") Long mmId) {
        MemberMission memberMission = missionService.completeMission(mmId);
        MissionResponse.CompleteMission completeMission = missionConverter.toCompleteMission(memberMission);

        return ApiResponse.onSuccess(completeMission);
    }

}
