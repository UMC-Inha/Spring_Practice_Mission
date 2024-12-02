package javalab.umc7th_mission.web.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

public class RestaurantRequestDTO {

    @Getter
    public static class AddRestaurant{
        @NotNull
        String name;
        @NotNull
        String type;
        @Length(max = 50)
        String address;
    }
}
