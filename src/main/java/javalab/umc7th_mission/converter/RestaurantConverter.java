package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Restaurant;
import javalab.umc7th_mission.web.dto.request.RestaurantRequestDTO;
import javalab.umc7th_mission.web.dto.response.RestaurantResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class RestaurantConverter {
    public Restaurant toEntity(RestaurantRequestDTO.AddRestaurant request) {
        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .type(request.getType())
                .build();
    }

    public RestaurantResponseDTO.AddRestaurant toAddRestaurantResponse(Restaurant restaurant) {
        return RestaurantResponseDTO.AddRestaurant.builder()
                .restaurantId(restaurant.getId())
                .address(restaurant.getAddress())
                .createdAt(restaurant.getCreateAt())
                .build();
    }

}
