package javalab.umc7th_mission.study.converter;

import javalab.umc7th_mission.study.domain.Region;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.web.dto.restaurant.RestaurantRequestDTO;
import javalab.umc7th_mission.study.web.dto.restaurant.RestaurantResponseDTO;

import java.time.LocalDate;

public class RestaurantConverter {
    public static RestaurantResponseDTO.AddRestaurantResultDTO toAddRestaurantResultDTO(Restaurant restaurant) {
        return RestaurantResponseDTO.AddRestaurantResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDate.now())
                .build();
    }
    public static Restaurant toRestaurant(RestaurantRequestDTO.AddRestaurantDto request, Region region){
        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .type(request.getType())
                .region(region)
                .build();
    }
}
