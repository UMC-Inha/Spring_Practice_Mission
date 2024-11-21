package javalab.umc7th_mission.study.web.dto.restaurant;

import jakarta.validation.constraints.NotNull;
import javalab.umc7th_mission.study.domain.Restaurant;
import lombok.Getter;

public class RestaurantRequestDTO {
    @Getter
    public static class AddRestaurantDto {
        @NotNull(message = "식당 이름은 필수 항목입니다.")
        String name;
        @NotNull(message = "식당 유형은 필수 항목입니다.")
        String type;
        @NotNull(message = "식당 주소는 필수 항목입니다.")
        String address;
        @NotNull(message = "지역 id는 필수 항목입니다.")
        Long regionId;
    }
}
