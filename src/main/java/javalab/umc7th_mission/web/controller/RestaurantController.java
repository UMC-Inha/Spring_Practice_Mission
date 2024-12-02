package javalab.umc7th_mission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import javalab.global.apiPayload.ApiResponse;
import javalab.global.validation.annotation.CheckPage;
import javalab.umc7th_mission.converter.RestaurantConverter;
import javalab.umc7th_mission.domain.Restaurant;
import javalab.umc7th_mission.service.RestaurantService;
import javalab.umc7th_mission.web.dto.request.RestaurantRequestDTO;
import javalab.umc7th_mission.web.dto.response.RestaurantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/missions/{restaurantID}")
    @Operation(summary = "특정 가게의 미션 조회 API", description = "특정 가게의 모든 미션 정보를 조회하는 API입니다.")
    @Parameter(name = "restaurantId",description = "식당 id를 입력해주세요.")
    public ApiResponse<RestaurantResponseDTO.getMissionList> getMissionList(@PathVariable(name = "restaurantId") Long restaurantID,
                                                                            @CheckPage @RequestParam(name = "page") Integer page) {
        Restaurant restaurant = restaurantService.findRestaurant(restaurantID);

        return ApiResponse.onSuccess(RestaurantResponseDTO.getMissionList.builder()
                .missionList(restaurant.getMissionList())
                .build());
    }
}
