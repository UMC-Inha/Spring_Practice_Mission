package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.web.dto.member.MemberResponseDTO;
import javalab.umc7th_mission.web.dto.store.StoreRequestDTO;
import javalab.umc7th_mission.web.dto.store.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDTO request) {
        Store store = Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
        return store;
    }
}
