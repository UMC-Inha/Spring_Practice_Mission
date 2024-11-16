package javalab.umc7th_mission.repository.MemberMissionRepository;

import javalab.umc7th_mission.web.dto.MissionDto;
import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MissionDto> findIncompleteMissionsByMemberId(Long memberId);
}