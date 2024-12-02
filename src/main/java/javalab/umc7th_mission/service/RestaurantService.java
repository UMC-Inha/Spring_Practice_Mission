package javalab.umc7th_mission.service;

import javalab.umc7th_mission.converter.RestaurantConverter;
import javalab.umc7th_mission.domain.Restaurant;
import javalab.umc7th_mission.repository.RestaurantRepository;
import javalab.umc7th_mission.web.dto.request.RestaurantRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantConverter restaurantConverter;

    @Transactional
    public Restaurant addRestaurant(RestaurantRequestDTO.AddRestaurant request) {
        Restaurant restaurant = restaurantConverter.toEntity(request);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public Restaurant findRestaurant(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).get();
    }

}
