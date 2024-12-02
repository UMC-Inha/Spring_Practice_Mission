package javalab.umc7th_mission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import javalab.global.apiPayload.ApiResponse;
import javalab.global.validation.annotation.CheckPage;
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
                                                                 @RequestBody @Valid MissionRequestDTO.AddMission request) {
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

    @GetMapping("/active/{memberId}")
    @Operation(summary = "특정 회원이 진행중인 미션 조회 API", description = "특정 회원이 진행하고 있는 미션에 대한 상세 정보를 조회하는 API입니다.")
    @Parameter(name = "memberId", description = "조회하고 싶은 회원의 Id를 입력해주세요")
    public ApiResponse<MissionResponseDTO.ActiveMissionList> activeMissionList(@PathVariable(name = "memberId") Long memberId,
                                                                               @CheckPage @RequestParam(name = "page") Integer page) {

        MissionResponseDTO.ActiveMissionList activeMissionList = missionService.getActiveMissionList(memberId, page);

        return ApiResponse.onSuccess(activeMissionList);
    }

    @PatchMapping("/{memberMissionId}")
    @Operation(summary = "미션 완료로 바꾸기 API", description = "진행중인 미션을 미션 완료로 바꾸는 API입니다.")
    @Parameter(name = "memberMissionId", description = "진행 완료한 특정 회원의 미션 ID를 입력해주세요")
    public ApiResponse<MissionResponseDTO.CompleteMission> completeMission(@PathVariable(name = "memberMissionId") Long mmId) {
        MemberMission memberMission = missionService.completeMission(mmId);
        MissionResponseDTO.CompleteMission completeMission = missionConverter.toCompleteMission(memberMission);

        return ApiResponse.onSuccess(completeMission);
    }
}
