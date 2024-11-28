package javalab.umc7th_mission.study.repository.MissionRepository;

import javalab.umc7th_mission.study.domain.Mission;
import javalab.umc7th_mission.study.domain.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Integer> , MissionRepositoryCustom {
 Page<Mission> findAllByRestaurant(Restaurant restaurant, Pageable pageable);
}
