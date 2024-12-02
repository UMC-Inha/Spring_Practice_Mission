package javalab.umc7th_mission.web.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

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
