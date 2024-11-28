package javalab.umc7th_mission.study.converter;

import javalab.umc7th_mission.study.domain.Region;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.domain.Review;
import javalab.umc7th_mission.study.web.dto.restaurant.RestaurantRequestDTO;
import javalab.umc7th_mission.study.web.dto.restaurant.RestaurantResponseDTO;
import javalab.umc7th_mission.study.web.dto.review.ReviewResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
