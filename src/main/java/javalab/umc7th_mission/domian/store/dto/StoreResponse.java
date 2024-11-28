package javalab.umc7th_mission.domian.store.dto;

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
}
