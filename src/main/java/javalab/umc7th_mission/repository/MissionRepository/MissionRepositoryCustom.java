package javalab.umc7th_mission.repository.MissionRepository;

import javalab.umc7th_mission.web.dto.MissionDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MissionRepositoryCustom {
    List<MissionDto> findAvailableMissions(Long memberId, Pageable pageable);
}
