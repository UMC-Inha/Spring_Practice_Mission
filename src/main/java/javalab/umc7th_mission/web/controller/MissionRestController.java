package javalab.umc7th_mission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.MemberConverter;
import javalab.umc7th_mission.converter.MissionConverter;
import javalab.umc7th_mission.converter.ReviewConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.service.MissionCommandService.MissionCommandService;
import javalab.umc7th_mission.web.dto.*;
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
    @Operation(
            summary = "예시 미션 추가",
            description = "새로운 미션을 가게에 추가합니다.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MissionRequestDTO.AddDTO.class),
                            examples = @ExampleObject(
                                    name = "미션 추가 예시",
                                    value = """
                        {
                            "storeId": 1,
                            "name": "첫 방문 포인트 이벤트",
                            "description": "가게 방문 시 +500점 추가 혜택",
                            "startDate": "2024-11-21",
                            "endDate": "2024-12-30",
                            "reward": 1000
                        }
                        """
                            )
                    )
            )
    )
    public ApiResponse<MissionResponseDTO.AddResultDTO> add(@RequestBody @Valid MissionRequestDTO.AddDTO request) {
        Mission mission = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }
}