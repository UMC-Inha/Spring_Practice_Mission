package javalab.umc7th_mission.repository.MissionRepository;

import javalab.umc7th_mission.domain.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findMissionsByStoreId(Long storeId, PageRequest request);
}