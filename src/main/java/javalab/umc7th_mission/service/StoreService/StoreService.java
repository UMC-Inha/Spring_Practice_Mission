package umc.spring.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.dto.StoreRequestDTO;
import umc.spring.repository.StoreRepository;
import umc.spring.repository.RegionRepository;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Transactional
    public Store addStore(StoreRequestDTO request) {
        // 지역 정보 확인
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));

        // Store 생성
        Store store = StoreConverter.toStore(request, region);
        return storeRepository.save(store);
    }
}
