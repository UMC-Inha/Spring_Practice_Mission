package umc.spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDTO {

    @NotNull
    private Long storeId;

    @NotNull
    private Long memberId;

    @NotBlank
    private String title;

    @NotNull
    private Float score;
}