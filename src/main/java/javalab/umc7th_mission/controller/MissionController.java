package umc.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.dto.MissionRequestDTO;
import umc.spring.dto.MissionResponseDTO;
import umc.spring.service.MissionService.MissionService;

import jakarta.validation.Valid;
import umc.spring.validation.annotation.PageValidation;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {

    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<?> addMission(@RequestBody @Valid MissionRequestDTO request) {
        try {
            // 성공적으로 미션을 추가한 경우
            MissionResponseDTO response = missionService.addMission(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            // 클라이언트 요청 오류
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // 서버 내부 오류
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 에러: " + e.getMessage());
        }
    }
    // 특정 가게의 미션 목록 조회
    @GetMapping("/store/{storeId}")
    public ResponseEntity<Page<MissionResponseDTO>> getMissionsByStore(
            @PathVariable Long storeId,
            @RequestParam("page") @PageValidation Integer page,
            @RequestParam("size") Integer size
    ) {
        Page<MissionResponseDTO> missions = missionService.getMissionsByStore(storeId, page, size);
        return ResponseEntity.ok(missions);
    }

    // 특정 회원이 진행 중인 미션 목록 조회
    @GetMapping("/member/{memberId}/missions")
    public ResponseEntity<Page<MissionResponseDTO>> getOngoingMissionsByMember(
            @PathVariable Long memberId,
            @RequestParam("page") @PageValidation Integer page,
            @RequestParam("size") Integer size
    ) {
        try {
            Page<MissionResponseDTO> missions = missionService.getOngoingMissionsByMember(memberId, page, size);
            return ResponseEntity.ok(missions);
        } catch (IllegalArgumentException e) {
            // 회원 ID가 잘못된 경우
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Page.empty());
        } catch (Exception e) {
            // 기타 서버 오류
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Page.empty());
        }
    }

    // 회원이 특정 미션에 도전하기
    @PostMapping("/{missionId}/start")
    public ResponseEntity<?> startMission(
            @PathVariable Long missionId,
            @RequestParam("memberId") Long memberId) {
        try {
            missionService.startMission(memberId, missionId);
            return ResponseEntity.ok("미션 도전이 성공적으로 시작되었습니다.");
        } catch (IllegalArgumentException e) {
            // 클라이언트 요청 오류
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // 서버 내부 오류
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 에러: " + e.getMessage());
        }
    }

    // 회원이 특정 미션 완료하기
    @PostMapping("/{missionId}/complete")
    public ResponseEntity<?> completeMission(
            @PathVariable Long missionId,
            @RequestParam("memberId") Long memberId) {
        try {
            missionService.completeMission(memberId, missionId);
            return ResponseEntity.ok("미션이 성공적으로 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 에러: " + e.getMessage());
        }
    }
}
