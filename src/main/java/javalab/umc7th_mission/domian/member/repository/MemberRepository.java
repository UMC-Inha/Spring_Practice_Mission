package javalab.umc7th_mission.domian.member.repository;

import javalab.umc7th_mission.domian.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
}
