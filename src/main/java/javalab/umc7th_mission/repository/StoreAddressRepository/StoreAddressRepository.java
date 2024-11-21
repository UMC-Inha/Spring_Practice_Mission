package javalab.umc7th_mission.repository.StoreAddressRepository;

import javalab.umc7th_mission.domain.mapping.StoreAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreAddressRepository extends JpaRepository<StoreAddress, Long>, StoreAddressRepositoryCustom {
}
