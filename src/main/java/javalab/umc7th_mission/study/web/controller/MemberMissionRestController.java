package javalab.umc7th_mission.study.web.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.study.apiPayload.ApiResponse;
import javalab.umc7th_mission.study.converter.MemberMissionConverter;
import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import javalab.umc7th_mission.study.service.MemberMissionService.MemberMissionCommandService;
import javalab.umc7th_mission.study.service.MemberMissionService.MemberMissionCommandServiceImpl;
import javalab.umc7th_mission.study.web.dto.member_mission.MemberMissionRequestDTO;
import javalab.umc7th_mission.study.web.dto.member_mission.MemberMissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/missions")
public class MemberMissionRestController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.AddMemberMissionResultDTO> add(@RequestBody @Valid MemberMissionRequestDTO.AddMemberMissionDto request){
        MemberMission memberMission = memberMissionCommandService.AddMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddMemberMissionResultDTO(memberMission));
    }
}
