package javalab.umc7th_mission.apiPayload.exception;

import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends RuntimeException {
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public MemberNotFoundException(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
    }

    public HttpStatus getStatus() {
        return status;
    }
}