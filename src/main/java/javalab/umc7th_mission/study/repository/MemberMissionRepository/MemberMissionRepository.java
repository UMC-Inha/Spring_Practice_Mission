package javalab.umc7th_mission.study.repository.MemberMissionRepository;

import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.domain.enums.MissionStatus;
import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom{
    MemberMission findMemberMissionByMemberIdAndMissionId(Long memberId, Long missionId);
    Page<MemberMission> findAllChallengingByMemberAndStatus(Member member, MissionStatus status, Pageable pageable);
}
