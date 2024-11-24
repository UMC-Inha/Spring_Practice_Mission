package javalab.umc7th_mission.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.dto.MemberRequestDTO;
import umc.spring.dto.MemberResponseDTO;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.service.MissionService.MissionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MissionService missionService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    // 미션 도전 시작 API
    @PostMapping("/{memberId}/missions/{missionId}/start")
    public ResponseEntity<ApiResponse<String>> startMission(
            @PathVariable Long memberId, @PathVariable Long missionId) {

        try {
            missionService.startMission(memberId, missionId);  // MissionService에서 도전 시작 처리
            // 미션 도전 성공 시 응답
            return ResponseEntity.ok(ApiResponse.onSuccess("미션 도전이 시작되었습니다."));
        } catch (GeneralException e) {
            // 이미 도전 중인 미션인 경우
            ApiResponse<String> errorResponse = ApiResponse.onFailure("BAD_REQUEST", "이미 도전 중인 미션입니다.", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            // 기타 서버 오류 발생 시
            ApiResponse<String> errorResponse = ApiResponse.onFailure("INTERNAL_SERVER_ERROR", "서버 오류: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
