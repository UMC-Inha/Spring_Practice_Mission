package javalab.umc7th_mission.domain.mission.controller;

import javalab.umc7th_mission.config.annotation.CheckPage;
import javalab.umc7th_mission.config.apipayload.ApiResponse;
import javalab.umc7th_mission.domain.mission.dto.MissionResponseDto;
import javalab.umc7th_mission.domain.mission.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionController {

    private static final Integer PAGE_SIZE = 10;
    private final MissionService service;

    @GetMapping("/store/{storeId}")
    public ApiResponse<Page<MissionResponseDto>> getMissionsByStore(
            @PathVariable Long storeId,
            @RequestParam @CheckPage Integer page
    ) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        Page<MissionResponseDto> missions = service.getMissionsByStore(storeId, pageable);
        return ApiResponse.onSuccess(missions);
    }
}
