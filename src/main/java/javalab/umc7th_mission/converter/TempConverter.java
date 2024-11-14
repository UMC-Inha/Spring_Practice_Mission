package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.web.dto.TempResponse;

public class TempConverter {
    // -> DTO로 만들기
    public static TempResponse.TempTestDTO toTempTestDTO() {
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag) {
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
