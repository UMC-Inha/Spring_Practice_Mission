package javalab.umc7th_mission.domian.member.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.apipayload.ApiResponse;
import javalab.umc7th_mission.domian.member.dto.MemberRequest;
import javalab.umc7th_mission.domian.member.dto.MemberResponse;
import javalab.umc7th_mission.domian.member.dto.MemberResponse.JoinResultDTO;
import javalab.umc7th_mission.domian.member.service.MemberService;
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
    public ApiResponse<JoinResultDTO> join(@RequestBody @Valid MemberRequest.JoinDto request) {
//        Member newMember = memberService.
        return null;
    }
}
