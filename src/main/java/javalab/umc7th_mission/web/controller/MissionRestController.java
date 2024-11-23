package javalab.umc7th_mission.web.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.MissionConverter;
import javalab.umc7th_mission.converter.ReviewConverter;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.service.MissionService.MissionCommandService;
import javalab.umc7th_mission.web.dto.mission.MissionRequestDTO;
import javalab.umc7th_mission.web.dto.mission.MissionResponseDTO;
import javalab.umc7th_mission.web.dto.review.ReviewRequestDTO;
import javalab.umc7th_mission.web.dto.review.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/mission")
    public ApiResponse<MissionResponseDTO.SaveResultDTO> save(@RequestBody @Valid MissionRequestDTO.SaveDTO request) {
        Mission mission = missionCommandService.save(request);
        return ApiResponse.onSuccess(MissionConverter.toSaveResultDTO(mission));
    }
}
