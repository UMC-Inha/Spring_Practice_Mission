package javalab.umc7th_mission.repository.MemberRepository;

import javalab.umc7th_mission.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//24.11.19 -> <Member, Integer> to <Member, Long>, @Repository add
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
