package javalab.umc7th_mission.domain.member.service;

import javalab.umc7th_mission.domain.member.dto.MemberRequest;
import javalab.umc7th_mission.domain.member.dto.MemberResponse;

public interface MemberService {

    MemberResponse.JoinResultDTO join(MemberRequest.JoinDTO request);

}
