package javalab.umc7th_mission.repository;

import javalab.umc7th_mission.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
