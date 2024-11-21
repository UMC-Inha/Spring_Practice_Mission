package javalab.umc7th_mission.service.StoreValidationService;

import javalab.umc7th_mission.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreValidationServiceImpl implements StoreValidationService {
    private final StoreRepository storeRepository;

    @Override
    public boolean isStoreExist(Long id) {
        return storeRepository.existsById(id);
    }
}
