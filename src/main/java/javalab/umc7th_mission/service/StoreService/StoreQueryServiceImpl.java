package javalab.umc7th_mission.service.StoreService;

import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
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
    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, BigDecimal score) {
        List<Store> stores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);
        stores.forEach(s -> System.out.println("store: " + s));

        return stores;
    }
}
