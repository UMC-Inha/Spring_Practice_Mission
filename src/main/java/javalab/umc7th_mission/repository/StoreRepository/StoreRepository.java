package javalab.umc7th_mission.repository.StoreRepository;

import javalab.umc7th_mission.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//24.11.19 @Repository add
@Repository
public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
