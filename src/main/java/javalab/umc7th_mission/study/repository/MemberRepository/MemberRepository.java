package javalab.umc7th_mission.study.repository.MemberRepository;

import javalab.umc7th_mission.study.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

}
