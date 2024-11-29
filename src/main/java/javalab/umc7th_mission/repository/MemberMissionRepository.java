package javalab.umc7th_mission.repository;

import javalab.umc7th_mission.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
}
