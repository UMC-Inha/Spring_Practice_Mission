package javalab.umc7th_mission.apipayload.exception.handler;


import study.apipayload.code.BaseErrorCode;
import study.apipayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
