package javalab.umc7th_mission.service.StoreService;

import javalab.umc7th_mission.domain.Store;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Store findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, BigDecimal score);

}
