package javalab.umc7th_mission.domain.member.repository;

import javalab.umc7th_mission.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}