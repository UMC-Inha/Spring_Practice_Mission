package javalab.umc7th_mission.study.service.MemberService;

import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.web.dto.member.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
