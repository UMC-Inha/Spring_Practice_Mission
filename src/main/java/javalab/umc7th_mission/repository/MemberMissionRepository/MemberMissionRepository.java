package javalab.umc7th_mission.repository.MemberMissionRepository;

import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {

    boolean existsByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus status);
}
