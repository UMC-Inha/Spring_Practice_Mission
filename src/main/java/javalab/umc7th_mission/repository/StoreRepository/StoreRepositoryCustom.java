package javalab.umc7th_mission.repository.StoreRepository;

import javalab.umc7th_mission.domain.Store;

import java.math.BigDecimal;
import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, BigDecimal score);
}
