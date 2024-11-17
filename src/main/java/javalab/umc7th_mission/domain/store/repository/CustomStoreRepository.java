package javalab.umc7th_mission.domain.store.repository;

import java.util.List;
import umc.umcjpaproject.domain.store.Store;

public interface CustomStoreRepository {

    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
