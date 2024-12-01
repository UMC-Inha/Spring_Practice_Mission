package javalab.umc7th_mission.service.StoreService;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.repository.MissionRepository.MissionRepository;
import javalab.umc7th_mission.repository.ReivewRepository.ReviewRepository;
import javalab.umc7th_mission.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;
    @Override
    public Store findStore(Long id) {
        return storeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, BigDecimal score) {
        List<Store> stores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);
        stores.forEach(s -> System.out.println("store: " + s));

        return stores;
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).orElseThrow();
        Page<Review> reviews = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return reviews;
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        return missionRepository.findAllByStoreId(storeId, PageRequest.of(page-1, 10, Sort.by(Sort.Direction.DESC, "createdAt")));
    }
}
