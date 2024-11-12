package javalab.umc7th_mission.study.repository.MemberMissionRepository;

import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    public List<MemberMission> challengingMemberMissions(Long memberId, Pageable pageable);
    public Long countCompletedMemberMissionsByMemberIdAndRegion(Long memberId, String regionName);
}
