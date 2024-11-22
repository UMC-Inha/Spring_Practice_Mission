package javalab.umc7th_mission.config.apipayload.exception;

import javalab.umc7th_mission.config.apipayload.code.BaseErrorCode;
import javalab.umc7th_mission.config.apipayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return code.getReasonHttpStatus();
    }

}
