package javalab.umc7th_mission.apipayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import study.apipayload.code.BaseErrorCode;
import study.apipayload.code.ErrorReasonDTO;


@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
