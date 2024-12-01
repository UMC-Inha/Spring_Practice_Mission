package javalab.umc7th_mission.repository.MemberMissionRepository;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {
    MemberMission findMemberMissionByMemberIdAndMissionId(Long memberId, Long missionId);

    Page<MemberMission> findAllByMemberIdAndStatus(Long memberId, MissionStatus status, Pageable pageable);

    @Modifying
    @Query("UPDATE MemberMission mm SET mm.status = 'DONE' WHERE mm.member.id = :memberId AND mm.mission.id = :missionId")
    int updateStatusToDone(@Param("memberId") Long memberId, @Param("missionId") Long missionId);

}
