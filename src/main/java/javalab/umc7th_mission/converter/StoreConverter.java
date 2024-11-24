package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.dto.StoreRequestDTO;
import umc.spring.dto.StoreResponseDTO;

public class StoreConverter {
    public static Store toStore(StoreRequestDTO request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .score(request.getScore())  // score 값 추가
                .build();
    }

    public static StoreResponseDTO toStoreResponseDTO(Store store) {
        return StoreResponseDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .regionName(store.getRegion().getName()) // 지역 이름도 포함
                .build();
    }
}