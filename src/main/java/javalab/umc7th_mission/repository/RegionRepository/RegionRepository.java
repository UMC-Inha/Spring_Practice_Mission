package javalab.umc7th_mission.repository.RegionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javalab.umc7th_mission.domain.Region;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    // 추가로 지역 이름으로 검색할 수 있는 메서드
    Region findByName(String name);
}

