package javalab.umc7th_mission.study.repository.MemberMissionRepository;

import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.domain.enums.MissionStatus;
import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom{
    MemberMission findMemberMissionByMemberIdAndMissionId(Long memberId, Long missionId);
    Page<MemberMission> findAllChallengingByMemberAndStatus(Member member, MissionStatus status, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "UPDATE MemberMission mm SET mm.status = 'COMPLETE' WHERE mm.member.id = :memberId AND mm.mission.id = :missionId AND mm.status = javalab.umc7th_mission.study.domain.enums.MissionStatus.CHALLENGING")
    int updateMemberMissionStatusComplete(@Param("memberId") Long memberId, @Param("missionId") Long missionId);
}
