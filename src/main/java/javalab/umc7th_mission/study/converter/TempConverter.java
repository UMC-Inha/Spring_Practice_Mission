package javalab.umc7th_mission.study.converter;

import javalab.umc7th_mission.study.web.dto.TempResponse;

public class TempConverter {
    public static TempResponse.TempTestDTO toTempDTO(){
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
