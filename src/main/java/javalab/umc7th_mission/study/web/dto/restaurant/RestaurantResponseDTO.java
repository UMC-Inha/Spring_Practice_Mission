package javalab.umc7th_mission.study.web.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
