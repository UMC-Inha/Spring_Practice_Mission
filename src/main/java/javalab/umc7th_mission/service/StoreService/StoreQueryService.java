package javalab.umc7th_mission.service.StoreService;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Store findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, BigDecimal score);

    Page<Review> getReviewList(Long storeId, Integer page);

    Page<Mission> getMissionList(Long storeId, Integer page);
}
