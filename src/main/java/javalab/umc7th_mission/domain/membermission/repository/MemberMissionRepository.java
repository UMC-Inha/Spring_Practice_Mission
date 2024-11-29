package javalab.umc7th_mission.domain.membermission.repository;

import java.util.Optional;
import javalab.umc7th_mission.domain.membermission.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Page<MemberMission> findByMemberIdAndStatus(Long memberId, String status, Pageable pageable);

    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}
