package javalab.umc7th_mission.domian.mission.repository;

import javalab.umc7th_mission.domian.mission.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission,Long> {

}
