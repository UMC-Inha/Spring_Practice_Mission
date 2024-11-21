package javalab.umc7th_mission.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import javalab.umc7th_mission.validation.annotation.ExistCategories;
import lombok.Getter;

import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class AddDto {
        @NotBlank(message = "가게 이름은 필수 항목입니다.")
        @Size(max = 30, message = "최대 30자까지 입력 가능합니다.")
        private final String name;

        @NotBlank(message = "전화번호는 필수 항목입니다.")
        //전화번호 형식 검증 정규식
        @Pattern(regexp = "^(02|0\\d{2})-\\d{3,4}-\\d{4}$", message = "전화번호 형식이 올바르지 않습니다.")
        private final String phoneNumber;

        @NotBlank(message = "가게 설명은 필수 항목입니다.")
        @Size(max = 500, message = "최대 500자까지 입력 가능합니다.")
        private final String description;

        @NotBlank(message = "오픈 시간은 필수 항목입니다.")
        @Size(max = 255, message = "최대 255자까지 입력 가능하니다.")
        @Pattern(
                regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$",
                message = "오픈 시간은 'HH:mm' 형식이어야 합니다. (예: 09:00, 23:59)"
        )
        private final String openingHours;

        @NotBlank(message = "마감 시간은 필수 항목입니다.")
        @Size(max = 255, message = "최대 255자까지 입력 가능하니다.")
        @Pattern(
                regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$",
                message = "마감 시간은 'HH:mm' 형식이어야 합니다. (예: 09:00, 23:59)"
        )
        private final String closingHours;

        private final String region;
        private final String detailedAddress;
        private final String zipcode;

        @ExistCategories
        private final List<Long> storeCategory;

        public AddDto(
            String name,
            String phoneNumber,
            String description,
            String openingHours,
            String closingHours,

            String region,
            String detailedAddress,
            String zipcode,
            List<Long> storeCategory
        ) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.description = description;
            this.openingHours = openingHours;
            this.closingHours = closingHours;
            this.region = region;
            this.detailedAddress = detailedAddress;
            this.zipcode = zipcode;
            this.storeCategory = storeCategory;
        }
    }
}
