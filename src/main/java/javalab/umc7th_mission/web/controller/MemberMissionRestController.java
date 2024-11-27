package javalab.umc7th_mission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.MemberMissionConverter;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.service.MemberMissionCommandService.MemberMissionCommandService;
import javalab.umc7th_mission.service.MemberMissionQueryService.MemberMissionQueryService;
import javalab.umc7th_mission.service.ReviewQueryService.ReviewQueryService;
import javalab.umc7th_mission.validation.annotation.ExistMember;
import javalab.umc7th_mission.validation.annotation.PositivePage;
import javalab.umc7th_mission.web.dto.MemberMissionRequestDTO;
import javalab.umc7th_mission.web.dto.MemberMissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/memberMissions")
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;
    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.AddResultDTO> join(@RequestBody @Valid MemberMissionRequestDTO.AddDTO resquest) {
        MemberMission memberMission = memberMissionCommandService.addMemberMission(resquest);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddResultDTO(memberMission));
    }

    @GetMapping("/{memberId}/challengingMissions")
    @Operation(summary = "해당 멤버의 도전 중인 미션 목록 조회 API", description = "특정 멤버의 도전중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. " +
            "Query String으로 Page 번호를 주세요!")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MemberMissionResponseDTO.ChallengingMissionPreviewListDTO> getChallengingMissions(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @RequestParam(name = "page") @PositivePage Integer page) {
        Integer adjustedPage = page - 1;
        MemberMissionResponseDTO.ChallengingMissionPreviewListDTO challengingMissionPreviewListDTO = memberMissionQueryService.getChallengingMemberMissions(memberId, adjustedPage);
        return ApiResponse.onSuccess(challengingMissionPreviewListDTO);
    }

    @PatchMapping("{memberId}/missions/{missionId}/complete")
    @Operation(summary = "도전 중인 미션 -> 미션 완료 API", description = "특정 멤버의 도전중인 미션을 미션 완료로 변경합니다! ")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MemberMissionResponseDTO.CompleteMissionResponseDTO> completeMission(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @PathVariable(name = "missionId") Long missionId) {

        MemberMissionResponseDTO.CompleteMissionResponseDTO completeMissionResponseDTO = memberMissionCommandService.completeMission(memberId, missionId);
        return ApiResponse.onSuccess(completeMissionResponseDTO);
    }
}