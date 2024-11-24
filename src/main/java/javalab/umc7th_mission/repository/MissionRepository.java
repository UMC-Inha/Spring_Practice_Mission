package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    // 미션이 이미 도전 중인지 확인
    boolean existsByStatusAndId(MissionStatus status, Long id);
}
