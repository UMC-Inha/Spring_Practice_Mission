package javalab.umc7th_mission.domian.store.dto;

import javalab.umc7th_mission.domian.mission.Mission;
import javalab.umc7th_mission.domian.region.Region;
import javalab.umc7th_mission.domian.store.Store;

public class StoreConverter {

    public static Store StoreByRegion(Region region, StoreRequest.JoinDTO joinDTO){
        return Store.builder()
            .name(joinDTO.getStoreName())
            .address(joinDTO.getStoreAddress())
            .score(joinDTO.getStoreScore())
            .region(region)  // 해당 지역과 연관 설정
            .build();
    }



}
