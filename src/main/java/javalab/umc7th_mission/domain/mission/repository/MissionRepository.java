package javalab.umc7th_mission.domain.mission.repository;

import javalab.umc7th_mission.domain.mission.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findByStoreId(Long storeId, Pageable pageable);

}
