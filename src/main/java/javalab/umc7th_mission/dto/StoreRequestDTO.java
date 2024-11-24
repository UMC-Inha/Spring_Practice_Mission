package umc.spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreRequestDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotNull
    private Long regionId;

    @NotNull
    private Float score;
}
