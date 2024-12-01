package javalab.umc7th_mission.domian.store.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreResponse {
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class CreateByRegionDTO{
        String inSuccess;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class CreateReviewToStore{
        String inSuccess;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class CreateMissionToStore{
        String inSuccess;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        List<ReviewPreViewDTO> reviewList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO {
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }
}
