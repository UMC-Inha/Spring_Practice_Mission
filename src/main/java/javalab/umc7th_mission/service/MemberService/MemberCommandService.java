package javalab.umc7th_mission.service.MemberService;

import jakarta.validation.Valid;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.web.dto.MemberRequestDTO;
import javalab.umc7th_mission.web.dto.MemberResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
