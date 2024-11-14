package javalab.umc7th_mission.repository.StoreRepository;

import javalab.umc7th_mission.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
