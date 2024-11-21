package javalab.umc7th_mission.service.StoreService;

import jakarta.transaction.Transactional;
import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.apiPayload.exception.FoodCategoryNotFoundException;
import javalab.umc7th_mission.apiPayload.exception.RegionNotFoundException;
import javalab.umc7th_mission.converter.StoreCategoryConverter;
import javalab.umc7th_mission.converter.StoreConverter;
import javalab.umc7th_mission.domain.FoodCategory;
import javalab.umc7th_mission.domain.Region;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.domain.mapping.StoreAddress;
import javalab.umc7th_mission.domain.mapping.StoreCategory;
import javalab.umc7th_mission.repository.FoodCategoryRepository.FoodCategoryRepository;
import javalab.umc7th_mission.repository.RegionRepository.RegionRepository;
import javalab.umc7th_mission.repository.StoreAddressRepository.StoreAddressRepository;
import javalab.umc7th_mission.repository.StoreRepository.StoreRepository;
import javalab.umc7th_mission.web.dto.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final StoreAddressRepository storeAddressRepository;
    private final RegionRepository regionRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.AddDto request) {
        Region region = regionRepository.findByName(request.getRegion());
        if (region == null) {
            throw new RegionNotFoundException(ErrorStatus.REGION_NOT_FOUND);
        }


        Store newStore = StoreConverter.toStore(request);
        StoreAddress storeAddress = StoreConverter.toStoreAddress(newStore, region, request);

        //StoreCategory 생성필요
        //foodCategory list 조회
        List<FoodCategory> foodCategoryList = request.getStoreCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryNotFoundException(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<StoreCategory> storeCategoryList = StoreCategoryConverter.toStoreCategoryList(foodCategoryList);
        storeCategoryList.forEach(memberPrefer -> {memberPrefer.setStore(newStore);});

        newStore.setCategoryList(storeCategoryList);
        storeAddress.setStore(newStore);
        newStore.setAddress(storeAddress);

        storeAddressRepository.save(storeAddress);
        return storeRepository.save(newStore);
    }
}
