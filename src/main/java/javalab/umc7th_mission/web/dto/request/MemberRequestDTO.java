package javalab.umc7th_mission.web.dto.request;

import javalab.umc7th_mission.domain.enums.Gender;
import lombok.Getter;

import java.time.LocalDate;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        Gender gender;
        LocalDate birth;
        String address;
        Boolean location_terms;
        Boolean marketing_terms;

    }
}
