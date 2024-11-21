package javalab.umc7th_mission.repository.MemberAddressRepository;

import javalab.umc7th_mission.domain.mapping.MemberAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberAddressRepository extends JpaRepository<MemberAddress, Long> {
}