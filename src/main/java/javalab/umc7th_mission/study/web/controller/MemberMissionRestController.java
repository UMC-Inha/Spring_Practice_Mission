package javalab.umc7th_mission.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import javalab.umc7th_mission.study.apiPayload.ApiResponse;
import javalab.umc7th_mission.study.converter.MemberMissionConverter;
import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import javalab.umc7th_mission.study.service.MemberMissionService.MemberMissionCommandService;
import javalab.umc7th_mission.study.service.MemberMissionService.MemberMissionCommandServiceImpl;
import javalab.umc7th_mission.study.validation.annotation.CheckPage;
import javalab.umc7th_mission.study.web.dto.member_mission.MemberMissionRequestDTO;
import javalab.umc7th_mission.study.web.dto.member_mission.MemberMissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/missions")
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.AddMemberMissionResultDTO> add(@RequestBody @Valid MemberMissionRequestDTO.AddMemberMissionDto request){
        MemberMission memberMission = memberMissionCommandService.AddMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddMemberMissionResultDTO(memberMission));
    }

    @GetMapping("/{memberId}/challengingMissions")
    @Operation(summary = "특정 멤버의 진행 중인 미션 목록 조회 API", description = "특정 멤버의 진행 중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name="memberId", description = "멤버의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberMissionResponseDTO.ChallengingMissionPreviewListDTO> getChallengingMissionList(@Valid @PathVariable(name="memberId") Long memberId,  @CheckPage @RequestParam(name="page") Integer page){
        Page<MemberMission> memberMissionPage = memberMissionCommandService.getChallengingMemberMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberMissionConverter.challengingMissionPreviewListDTO(memberMissionPage));
    }

    @PatchMapping("/{memberId}/missions/{missionId}/complete")
    @Operation(summary = "특정 멤버의 진행 중인 미션을 진행 완료로 변경 API", description = "특정 멤버의 진행 중인 미션을  진행 완료로 변경하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name="memberId", description = "멤버의 아이디, path variable 입니다!"),
            @Parameter(name="missionId", description = "미션의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberMissionResponseDTO.ChangeCompletedMemberMissionResultDTO> changeCompletedMemberMission(@Valid @PathVariable(name="memberId") Long memberId, @Valid @PathVariable(name="missionId") Long missionId){
        MemberMission memberMission = memberMissionCommandService.changeMemberMissionStatusComplete(memberId, missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.changeCompletedMemberMissionResultDTO(memberMission));
    }
}
