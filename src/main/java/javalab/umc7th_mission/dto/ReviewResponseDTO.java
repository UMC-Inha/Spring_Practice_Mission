package umc.spring.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponseDTO {

    private Long id;
    private String title;
    private Float score;
    private Long storeId;
    private Long memberId;
}
