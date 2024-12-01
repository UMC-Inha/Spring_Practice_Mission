package javalab.umc7th_mission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.MemberMissionConverter;
import javalab.umc7th_mission.converter.StoreConverter;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.service.MemberMissionService.MemberMissionCommandService;
import javalab.umc7th_mission.service.MemberMissionService.MemberMissionQueryService;
import javalab.umc7th_mission.service.MemberService.MemberQueryService;
import javalab.umc7th_mission.validation.annotation.CheckPage;
import javalab.umc7th_mission.web.dto.member_mission.MemberMissionRequestDTO;
import javalab.umc7th_mission.web.dto.member_mission.MemberMissionResponseDTO;
import javalab.umc7th_mission.web.dto.store.StoreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;


    @PostMapping("/member/mission/start")
    public ApiResponse<MemberMissionResponseDTO.SaveResultDTO> start(@RequestBody @Valid MemberMissionRequestDTO.SaveDTO request) {
        MemberMission memberMission = memberMissionCommandService.start(request.getMemberId(), request.getMissionId());
        return ApiResponse.onSuccess(MemberMissionConverter.toSaveResultDTO(memberMission));
    }

    @PatchMapping("/members/{memberId}/missions/{missionId}/done")
    @Operation(summary = "진행 중인 미션 진행 완료로 변경 API", description = "진행 완료된 미션을 진행 완료로 바꾸는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원의 아이디, path variable 입니다!"),
            @Parameter(name = "missionId", description = "미션의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberMissionResponseDTO.DoneResultDTO> done(@Valid @PathVariable(name = "memberId") Long memberId, @Valid @PathVariable(name = "missionId") Long missionId) {
        MemberMission memberMission = memberMissionCommandService.done(memberId, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toDoneResultDTO(memberMission));
    }

    @GetMapping("/members/{memberId}/missions/in-progress")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API", description = "내가 진행 중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberMissionResponseDTO.MissionPreviewListDTO> getMissionList(@Valid @CheckPage @PathVariable(name = "memberId") Long memberId, @RequestParam(name = "page") Integer page) {
        Page<MemberMission> memberMissionList = memberMissionQueryService.getMemberMissionInProgressList(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.missionPreviewListDTO(memberMissionList));
    }
}
