package javalab.umc7th_mission.domian.store.dto;

import java.util.List;
import java.util.stream.Collectors;
import javalab.umc7th_mission.domian.mission.Mission;
import javalab.umc7th_mission.domian.region.Region;
import javalab.umc7th_mission.domian.review.Review;
import javalab.umc7th_mission.domian.store.Store;
import javalab.umc7th_mission.domian.store.dto.StoreResponse.ReviewPreViewDTO;
import org.springframework.data.domain.Page;

public class StoreConverter {

    public static Store StoreByRegion(Region region, StoreRequest.JoinDTO joinDTO){
        return Store.builder()
            .name(joinDTO.getStoreName())
            .address(joinDTO.getStoreAddress())
            .score(joinDTO.getStoreScore())
            .region(region)  // 해당 지역과 연관 설정
            .build();
    }

    public static StoreResponse.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponse.ReviewPreViewDTO.builder()
            .ownerNickname(review.getMember().getName())
            .score(review.getScore())
            .createdAt(review.getCreatedAt().toLocalDate())
            .body(review.getBody())
            .build();
    }
    public static StoreResponse.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
            .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponse.ReviewPreViewListDTO.builder()
            .isLast(reviewList.isLast())
            .isFirst(reviewList.isFirst())
            .totalPage(reviewList.getTotalPages())
            .totalElements(reviewList.getTotalElements())
            .listSize(reviewPreViewDTOList.size())
            .reviewList(reviewPreViewDTOList)
            .build();
    }



}
