package javalab.umc7th_mission.study.service.RestaurantService;

import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.web.dto.restaurant.RestaurantRequestDTO;

public interface RestaurantCommandService {
    Restaurant AddRestaurant(RestaurantRequestDTO.AddRestaurantDto request);
}
