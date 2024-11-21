package javalab.umc7th_mission.repository.MemberPreferRepository;

import javalab.umc7th_mission.domain.mapping.MemberPrefer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPreferRepository extends JpaRepository<MemberPrefer, Long> {
}