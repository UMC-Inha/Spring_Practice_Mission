package javalab.umc7th_mission.web.dto.response;

import jakarta.validation.constraints.NotNull;
import javalab.umc7th_mission.domain.Mission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class RestaurantResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddRestaurant{
        Long restaurantId;
        String address;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class getMissionList{
        List<Mission> missionList;
    }
}
