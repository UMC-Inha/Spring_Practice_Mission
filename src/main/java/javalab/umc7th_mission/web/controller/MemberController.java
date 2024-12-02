package javalab.umc7th_mission.web.controller;

import jakarta.validation.Valid;
import javalab.global.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.MemberConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.service.MemberService;
import javalab.umc7th_mission.web.dto.request.MemberRequestDTO;
import javalab.umc7th_mission.web.dto.response.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
//        Member newMember = memberService.
        return null;
    }
}
