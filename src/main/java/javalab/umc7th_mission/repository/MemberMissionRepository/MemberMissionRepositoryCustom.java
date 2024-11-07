package javalab.umc7th_mission.repository.MemberMissionRepository;

import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.web.dto.HomePageDto;
import javalab.umc7th_mission.web.dto.MissionDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MissionDto> findMissionsByMemberIdAndStatus(Long memberId, Pageable pageable);
    List<HomePageDto> findMissionByMemberIdAndRegion(Long memberId, String regionName, Pageable pageable);
}
