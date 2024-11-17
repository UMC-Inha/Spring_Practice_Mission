package javalab.global.apiPayload.exception.handler;

import javalab.global.apiPayload.code.BaseErrorCode;
import javalab.global.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}