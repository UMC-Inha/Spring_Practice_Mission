package javalab.umc7th_mission.study.web.dto.restaurant;

import javalab.umc7th_mission.study.web.dto.review.ReviewResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class RestaurantResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddRestaurantResultDTO{
        Long restaurantId;
        LocalDate createdAt;
    }
}
