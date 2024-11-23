package javalab.umc7th_mission.web.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.MemberMissionConverter;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.service.MemberMissionService.MemberMissionCommandService;
import javalab.umc7th_mission.web.dto.member_mission.MemberMissionRequestDTO;
import javalab.umc7th_mission.web.dto.member_mission.MemberMissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;


    @PostMapping("/member/mission/start")
    public ApiResponse<MemberMissionResponseDTO.SaveResultDTO> start(@RequestBody @Valid MemberMissionRequestDTO.SaveDTO request) {
        MemberMission memberMission = memberMissionCommandService.start(request.getMemberId(), request.getMissionId());
        return ApiResponse.onSuccess(MemberMissionConverter.toSaveResultDTO(memberMission));
    }
}
