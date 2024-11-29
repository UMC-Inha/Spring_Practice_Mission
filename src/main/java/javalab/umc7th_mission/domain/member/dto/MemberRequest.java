package javalab.umc7th_mission.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import javalab.umc7th_mission.config.validation.ExistCategories;

public final class MemberRequest {

    private MemberRequest() {
    }

    public record JoinDTO(
            @NotBlank String name,
            @NotBlank String gender,
            @NotNull Integer age,
            @NotNull Integer birthYear,
            @NotNull Integer birthMonth,
            @NotNull Integer birthDay,
            @Size(min = 5, max = 12) String address,
            @Size(min = 5, max = 12) String specAddress,
            @ExistCategories List<Long> preferCategoryIds
    ) {

    }

}
