package javalab.umc7th_mission.domain.member;

import javalab.umc7th_mission.config.apipayload.code.status.ErrorStatus;
import javalab.umc7th_mission.config.apipayload.exception.GeneralException;

public enum Gender {

    FEMALE, MALE;

    public static Gender to(String value) {
        try {
            return Gender.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new GeneralException(ErrorStatus.GENDER_INVALID_DATA);
        }
    }

}
