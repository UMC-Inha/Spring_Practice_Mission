package javalab.umc7th_mission.study.web.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.study.apiPayload.ApiResponse;
import javalab.umc7th_mission.study.converter.MissionConverter;
import javalab.umc7th_mission.study.domain.Mission;
import javalab.umc7th_mission.study.service.MissionService.MissionCommandService;
import javalab.umc7th_mission.study.web.dto.mission.MissionRequestDTO;
import javalab.umc7th_mission.study.web.dto.mission.MissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> add(@RequestBody @Valid MissionRequestDTO .AddMissionDto request){
        Mission mission = missionCommandService.AddMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }
}
