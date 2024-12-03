package javalab.umc7th_mission.domian.membermission.repository;

import javalab.umc7th_mission.domian.enums.MissionStatus;
import javalab.umc7th_mission.domian.member.Member;
import javalab.umc7th_mission.domian.membermission.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
    Page<MemberMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);

}