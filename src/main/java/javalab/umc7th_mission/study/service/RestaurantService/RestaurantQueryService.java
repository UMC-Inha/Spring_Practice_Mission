package javalab.umc7th_mission.study.service.RestaurantService;

import  javalab.umc7th_mission.study.domain.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {

    Optional<Restaurant> findRestaurant(Long id);
    List<Restaurant> findRestaurantsByName(String name);
}
