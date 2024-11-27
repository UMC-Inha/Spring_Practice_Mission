package javalab.umc7th_mission.repository.MemberMissionRepository;

import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {

    boolean existsByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus status);

    @Query("SELECT mm FROM MemberMission mm " +
            "WHERE mm.member.id = :memberId " +
            "AND mm.status = javalab.umc7th_mission.domain.enums.MissionStatus.CHALLENGING")
    Page<MemberMission> findChallengingMissionByMemberId(@Param("memberId") Long memberId, PageRequest request);

    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}