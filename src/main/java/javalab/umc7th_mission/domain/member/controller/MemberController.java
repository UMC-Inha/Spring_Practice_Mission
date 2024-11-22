package javalab.umc7th_mission.domain.member.controller;

import javalab.umc7th_mission.domain.member.dto.MemberRequest.JoinDTO;
import javalab.umc7th_mission.domain.member.dto.MemberResponse.JoinResultDTO;
import javalab.umc7th_mission.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    @PostMapping("/")
    public JoinResultDTO join(
            @RequestBody @Validated JoinDTO request
    ){
        return service.join(request);
    }

}
