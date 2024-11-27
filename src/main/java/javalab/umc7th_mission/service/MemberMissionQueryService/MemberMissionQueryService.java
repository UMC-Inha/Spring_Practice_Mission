package javalab.umc7th_mission.service.MemberMissionQueryService;

import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.web.dto.MemberMissionResponseDTO;
import org.springframework.data.domain.Page;

public interface MemberMissionQueryService {
    MemberMissionResponseDTO.ChallengingMissionPreviewListDTO getChallengingMemberMissions(Long memberId, Integer page);
}
