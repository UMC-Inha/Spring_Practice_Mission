package javalab.umc7th_mission.study.repository.MissionRepository;

import javalab.umc7th_mission.study.domain.Mission;
import javalab.umc7th_mission.study.dto.AvailableMissionDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MissionRepositoryCustom {
    public List<AvailableMissionDTO> findMissionsNotInMemberMission(Long memberId, String regionName, Pageable pageable);
}
