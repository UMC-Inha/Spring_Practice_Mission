package javalab.umc7th_mission.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.dto.MissionRequestDTO;
import umc.spring.dto.MissionResponseDTO;
import umc.spring.service.MissionService.MissionService;

import jakarta.validation.Valid;

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
}
