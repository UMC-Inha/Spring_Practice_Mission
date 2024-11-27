package javalab.umc7th_mission.apiPayload.exception;

import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import org.springframework.http.HttpStatus;

public class InvalidPageException extends RuntimeException {
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public InvalidPageException(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
    }

    public HttpStatus getStatus() {
        return status;
    }
}
