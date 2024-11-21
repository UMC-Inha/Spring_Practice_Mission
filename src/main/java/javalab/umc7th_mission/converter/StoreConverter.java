package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Region;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.domain.mapping.StoreAddress;
import javalab.umc7th_mission.web.dto.MemberRequestDTO;
import javalab.umc7th_mission.web.dto.StoreRequestDTO;
import javalab.umc7th_mission.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static StoreResponseDTO.AddResultDTO toAddResultDTO(Store store) {
        return new StoreResponseDTO.AddResultDTO(
                store.getId(),
                store.getCreatedAt()
        );
    }

    public static Store toStore(StoreRequestDTO.AddDto request) {
        return Store.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .description(request.getDescription())
                .openingHours(request.getOpeningHours())
                .closingHours(request.getClosingHours())
                .build();
    }

    public static StoreAddress toStoreAddress(Store store, Region region, StoreRequestDTO.AddDto request) {
        return StoreAddress.builder()
                .region(region)
                .store(store)
                .detailAddress(request.getDetailedAddress())
                .zipCode(request.getZipcode())
                .build();
    }
}


