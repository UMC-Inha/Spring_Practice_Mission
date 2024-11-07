package javalab.umc7th_mission.repository.StoreRepository;

import javalab.umc7th_mission.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {

}
