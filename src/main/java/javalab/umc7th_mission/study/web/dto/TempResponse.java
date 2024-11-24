package javalab.umc7th_mission.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TempResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempTestDTO{
        String testString;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempExceptionDTO{
        Integer flag;
    }

}
