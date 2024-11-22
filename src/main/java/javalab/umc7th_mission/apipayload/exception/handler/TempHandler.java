package javalab.umc7th_mission.apipayload.exception.handler;


import javalab.umc7th_mission.apipayload.code.BaseErrorCode;
import javalab.umc7th_mission.apipayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
