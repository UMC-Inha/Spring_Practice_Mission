package javalab.umc7th_mission.web.controller;

import jakarta.validation.Valid;
import javalab.global.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.RestaurantConverter;
import javalab.umc7th_mission.domain.Restaurant;
import javalab.umc7th_mission.service.RestaurantService;
import javalab.umc7th_mission.web.dto.request.RestaurantRequestDTO;
import javalab.umc7th_mission.web.dto.response.RestaurantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantConverter restaurantConverter;

    @PostMapping()
    public ApiResponse<RestaurantResponseDTO.AddRestaurant> addRestaurant(@RequestBody @Valid RestaurantRequestDTO.AddRestaurant request) {
        Restaurant restaurant = restaurantService.addRestaurant(request);
        RestaurantResponseDTO.AddRestaurant addRestaurantResponse = restaurantConverter.toAddRestaurantResponse(restaurant);

        return ApiResponse.onSuccess(addRestaurantResponse);
    }
}
