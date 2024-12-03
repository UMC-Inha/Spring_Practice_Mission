package javalab.umc7th_mission.domian.member.dto;



import javalab.umc7th_mission.domian.enums.Gender;
import lombok.Getter;

import java.time.LocalDate;

public class MemberRequest {

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
