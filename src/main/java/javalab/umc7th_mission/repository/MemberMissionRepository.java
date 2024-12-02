package javalab.umc7th_mission.repository;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.enums.Status;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
    Page<MemberMission> findAllByMemberAndStatus(Member member, Status status, PageRequest pageRequest);

}
