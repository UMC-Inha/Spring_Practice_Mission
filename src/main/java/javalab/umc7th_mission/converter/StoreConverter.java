package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Region;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.domain.mapping.StoreAddress;
import javalab.umc7th_mission.web.dto.StoreRequestDTO;
import javalab.umc7th_mission.web.dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

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

    //24.11.26 ReviewPreview 관련 Converter 추가
    public static StoreResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review) {
        return new StoreResponseDTO.ReviewPreviewDTO(
                review.getMember().getNickname(),
                review.getRating(),
                review.getContent(),
                review.getCreatedAt().toLocalDate()
        );
    }

    public static StoreResponseDTO.ReviewPreviewListDTO reviewPreViewListDTO(Page<Review> reviewList) {
        List<StoreResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreviewDTO).toList();

        return new StoreResponseDTO.ReviewPreviewListDTO(
                reviewPreviewDTOList,
                reviewPreviewDTOList.size(),
                reviewList.getTotalPages(),
                reviewList.getTotalElements(),
                reviewList.isFirst(),
                reviewList.isLast()
        );
    }
}