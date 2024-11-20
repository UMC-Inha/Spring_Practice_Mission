package javalab.umc7th_mission.web.dto;

import jakarta.validation.constraints.*;
import javalab.umc7th_mission.domain.enums.Gender;
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

        //어노테이션 추가 필요 지역 관련 이슈
        private final String region;
        private final String detailedAddress;
        private final String zipcode;
        List<Long> preferCategory;

        public JoinDto(
            @NotBlank(message = "이름은 필수 항목입니다.")
            @Size(max = 20, message = "이름은 최대 20자까지 가능합니다.")
            String name,

            @NotBlank(message = "닉네임은 필수 항목입니다.")
            @Size(max = 20, message = "닉네임은 최대 20자까지 가능합니다.")
            String nickname,

            @NotBlank(message = "전화번호는 필수 항목입니다.")
            //전화번호 형식 검증 정규식
            @Pattern(regexp = "^(02|0\\d{2})-\\d{3,4}-\\d{4}$", message = "전화번호 형식이 올바르지 않습니다.")
            String phoneNumber,

            @NotNull(message = "성별은 필수 항목입니다.")
            Gender gender,

            @NotBlank(message = "이메일은 필수 항목입니다.")
            @Email(message = "이메일 형식이 올바르지 않습니다.")
            @Size(max = 50, message = "이메일은 최대 50자까지 가능합니다.")
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
