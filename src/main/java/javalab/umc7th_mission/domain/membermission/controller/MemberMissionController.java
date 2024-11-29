package javalab.umc7th_mission.domain.membermission.controller;

import javalab.umc7th_mission.config.annotation.CheckPage;
import javalab.umc7th_mission.config.apipayload.ApiResponse;
import javalab.umc7th_mission.domain.membermission.dto.MemberMissionResponseDTO;
import javalab.umc7th_mission.domain.membermission.service.MemberMissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MemberMissionController {

    private final MemberMissionService memberMissionService;
    private static final Integer PAGE_SIZE = 10;

    @GetMapping("/member/{memberId}/ongoing")
    public ApiResponse<Page<MemberMissionResponseDTO>> getOngoingMissionsByMember(
            @PathVariable Long memberId,
            @RequestParam @CheckPage Integer page
    ) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        return ApiResponse.onSuccess(
                memberMissionService.getOngoingMissionsByMember(memberId, pageable));
    }

    @PatchMapping("/member/{memberId}/complete/{missionId}")
    public ResponseEntity<String> completeMission(
            @PathVariable Long memberId,
            @PathVariable Long missionId
    ) {
        memberMissionService.completeMission(memberId, missionId);
        return ResponseEntity.ok("Mission marked as complete");
    }
}
