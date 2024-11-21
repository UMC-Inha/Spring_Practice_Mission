package javalab.umc7th_mission.study.web.dto.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import javalab.umc7th_mission.study.validation.annotation.ExistCategories;
import lombok.Getter;

import java.util.Date;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank(message = "이름은 필수 항목입니다.")
        String name;
        @NotBlank(message = "주소는 필수 항목입니다.")
        @Size(max = 100)
        String address;
        @NotNull(message = "생년월일은 필수 항목입니다.")
        Date birth;
        @ExistCategories
        List<Long> memberFoodList;
    }
}
