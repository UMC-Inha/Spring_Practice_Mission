package javalab.umc7th_mission.service.MemberMissionService;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MemberMissionQueryService {
    Page<MemberMission> getMemberMissionInProgressList(Long memberId, Integer page);
}
