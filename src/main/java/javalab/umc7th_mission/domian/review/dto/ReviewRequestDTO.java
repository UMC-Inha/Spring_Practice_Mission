package javalab.umc7th_mission.domian.review.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

public class ReviewRequestDTO {

    @Getter
    public static class AddReview{
        @NotNull
        Long memberId;
        @Length(max = 200)
        String content;
        @Max(5)
        Double score;

    }
}
