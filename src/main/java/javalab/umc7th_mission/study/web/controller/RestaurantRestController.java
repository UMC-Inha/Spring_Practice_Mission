package javalab.umc7th_mission.study.web.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.study.apiPayload.ApiResponse;
import javalab.umc7th_mission.study.converter.RestaurantConverter;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.service.RestaurantService.RestaurantCommandService;
import javalab.umc7th_mission.study.web.dto.restaurant.RestaurantRequestDTO;
import javalab.umc7th_mission.study.web.dto.restaurant.RestaurantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/region/restaurants")
public class RestaurantRestController {
    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponseDTO.AddRestaurantResultDTO> add(@RequestBody @Valid RestaurantRequestDTO.AddRestaurantDto request) {
        Restaurant restaurant = restaurantCommandService.AddRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toAddRestaurantResultDTO(restaurant));
    }
}
