package javalab.umc7th_mission.apiPayload.exception;

import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import org.springframework.http.HttpStatus;

public class StoreNotFoundException extends RuntimeException {
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public StoreNotFoundException(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
    }

    public HttpStatus getStatus() {
        return status;
    }
}
