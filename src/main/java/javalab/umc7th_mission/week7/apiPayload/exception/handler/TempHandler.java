package javalab.umc7th_mission.week7.apiPayload.exception.handler;

import javalab.umc7th_mission.week7.apiPayload.code.BaseErrorCode;
import javalab.umc7th_mission.week7.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
