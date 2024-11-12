package javalab.umc7th_mission.study.repository.MissionRepository;

import javalab.umc7th_mission.study.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Integer> , MissionRepositoryCustom {
}
