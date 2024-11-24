package javalab.umc7th_mission.study.web.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import javalab.umc7th_mission.study.validation.annotation.ExistRestaurant;
import lombok.Getter;


public class ReviewRequestDTO {
    @Getter
    public static class AddReviewDto{

        @NotNull(message = "별점은 필수 항목입니다.")
        @Min(0) @Max(5)
        Integer score;

        @Size(max=500, message="리뷰 내용은 500자 이내로 작성해야합니다.")
        String content;

        @NotNull(message = "회원 id는 필수 항목입니다.")
        Long memberId;

        @ExistRestaurant
        Long restaurantId;
    }

}
