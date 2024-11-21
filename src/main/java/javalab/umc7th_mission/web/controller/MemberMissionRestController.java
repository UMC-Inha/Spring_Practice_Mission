package javalab.umc7th_mission.web.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.MemberConverter;
import javalab.umc7th_mission.converter.MemberMissionConverter;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.service.MemberMissionCommandService.MemberMissionCommandService;
import javalab.umc7th_mission.web.dto.MemberMissionRequestDTO;
import javalab.umc7th_mission.web.dto.MemberMissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memberMissions")
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.AddResultDTO> join(@RequestBody @Valid MemberMissionRequestDTO.AddDTO resquest) {
        MemberMission memberMission = memberMissionCommandService.addMemberMission(resquest);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddResultDTO(memberMission));
    }
}
