package javalab.umc7th_mission.study.repository.MemberMissionRepository;

import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Integer>, MemberMissionRepositoryCustom{

}
