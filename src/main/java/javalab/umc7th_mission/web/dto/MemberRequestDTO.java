package javalab.umc7th_mission.web.dto;

import jakarta.validation.constraints.*;
import javalab.umc7th_mission.domain.enums.Gender;
import javalab.umc7th_mission.validation.annotation.ExistCategories;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


public class MemberRequestDTO {

    //회원 가입 시 사용하는 DTO
    //빌더를 안쓰고 생성자 주입방식 이용
    @Getter
    public static class JoinDto {
        @NotBlank(message = "이름은 필수 항목입니다.")
        @Size(max = 20, message = "이름은 최대 20자까지 가능합니다.")
        private final String name;

        @NotBlank(message = "닉네임은 필수 항목입니다.")
        @Size(max = 20, message = "닉네임은 최대 20자까지 가능합니다.")
        private final String nickname;

        @NotBlank(message = "전화번호는 필수 항목입니다.")
        //전화번호 형식 검증 정규식
        @Pattern(regexp = "^(02|0\\d{2})-\\d{3,4}-\\d{4}$", message = "전화번호 형식이 올바르지 않습니다.")
        private final String phoneNumber;

        @NotNull(message = "성별은 필수 항목입니다.")
        private final Gender gender;

        @NotBlank(message = "이메일은 필수 항목입니다.")
        @Email(message = "이메일 형식이 올바르지 않습니다.")
        @Size(max = 50, message = "이메일은 최대 50자까지 가능합니다.")
        private final String email;

        //24.11.21 fix/#7
        @NotBlank(message = "지역명은 필수 항목입니다.")
        @Size(max = 50, message = "지역명은 최대 50자까지 가능합니다.")
        private final String region;

        @NotBlank(message = "세부 주소는 필수 항목입니다.")
        @Size(max = 100, message = "세부 주소는 최대 100자까지 가능합니다.")
        private final String detailedAddress;

        @NotBlank(message = "우편번호는 필수 항목입니다.")
        @Size(max = 40, message = "우편번호는 최대 40자까지 가능합니다.")
        private final String zipcode;

        @ExistCategories
        List<Long> preferCategory;

        /*
            24.11.21 fix/#7 -> remove @
            유효성 검증은 객체 생성 이후에 처리되도록 설계 -> 생성자에서 어노테이션을 적용할 이유 없음
         */
        public JoinDto(
            String name,
            String nickname,
            String phoneNumber,
            Gender gender,
            String email,
            String region,
            String detailedAddress,
            String zipcode,
            List<Long> preferCategory
        ) {
            this.name = name;
            this.nickname = nickname;
            this.phoneNumber = phoneNumber;
            this.gender = gender;
            this.email = email;
            this.region = region;
            this.detailedAddress = detailedAddress;
            this.zipcode = zipcode;
            this.preferCategory = preferCategory;
        }
    }
}
