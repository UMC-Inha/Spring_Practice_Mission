package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.enums.MissionStatus;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    // 특정 회원이 특정 미션에 도전 중인지 확인
    boolean existsByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus status);
    boolean existsByMissionIdAndStatus(Long missionId, MissionStatus missionStatus);

    // 회원-미션 관계 조회
    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
    // 특정 회원의 진행 중인 미션 목록 조회
    Page<MemberMission> findByMemberIdAndStatus(Long memberId, MissionStatus status, Pageable pageable);
}
