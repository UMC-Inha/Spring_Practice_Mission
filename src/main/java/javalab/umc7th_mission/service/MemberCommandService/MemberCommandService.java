package javalab.umc7th_mission.service.MemberCommandService;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}