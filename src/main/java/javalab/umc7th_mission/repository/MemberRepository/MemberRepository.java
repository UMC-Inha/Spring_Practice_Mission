package javalab.umc7th_mission.repository.MemberRepository;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.enums.MemberStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
