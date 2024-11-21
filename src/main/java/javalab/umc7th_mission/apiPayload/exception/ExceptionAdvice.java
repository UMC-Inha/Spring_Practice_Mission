package javalab.umc7th_mission.apiPayload.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.apiPayload.ErrorReasonDTO;
import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestControllerAdvice(annotations = {RestController.class})
public class ExceptionAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<Object> validation(ConstraintViolationException e, WebRequest request) {
        String errorMessage = e.getConstraintViolations().stream()
                .map(constraintViolation -> constraintViolation.getMessage())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("ConstraintViolationException 추출 도중 에러 발생"));

        return handleExceptionInternalConstraint(e, ErrorStatus.valueOf(errorMessage), HttpHeaders.EMPTY,request);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new LinkedHashMap<>();

        e.getBindingResult().getFieldErrors().stream()
                .forEach(fieldError -> {
                    String fieldName = fieldError.getField();
                    String errorMessage = Optional.ofNullable(fieldError.getDefaultMessage()).orElse("");
                    errors.merge(fieldName, errorMessage, (existingErrorMessage, newErrorMessage) -> existingErrorMessage + ", " + newErrorMessage);
                });

        return handleExceptionInternalArgs(e,HttpHeaders.EMPTY,ErrorStatus.valueOf("_BAD_REQUEST"),request,errors);
    }

    @ExceptionHandler
    public ResponseEntity<Object> exception(Exception e, WebRequest request) {
        e.printStackTrace();

        return handleExceptionInternalFalse(e, ErrorStatus._INTERNAL_SERVER_ERROR, HttpHeaders.EMPTY, ErrorStatus._INTERNAL_SERVER_ERROR.getHttpStatus(),request, e.getMessage());
    }

    @ExceptionHandler(value = GeneralException.class)
    public ResponseEntity onThrowException(GeneralException generalException, HttpServletRequest request) {
        ErrorReasonDTO errorReasonHttpStatus = generalException.getErrorReasonHttpStatus();
        return handleExceptionInternal(generalException,errorReasonHttpStatus,null,request);
    }

    //FoodCatoryNotFoundException에 대한 에러 처리
    @ExceptionHandler(FoodCategoryNotFoundException.class)
    public ResponseEntity<Object> handleFoodCategoryNotFoundException(FoodCategoryNotFoundException e, HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);

        ApiResponse<Object> body = ApiResponse.onFailure(
                ErrorStatus.FOOD_CATEGORY_NOT_FOUND.getCode(),
                ErrorStatus.FOOD_CATEGORY_NOT_FOUND.getMessage(),
                null
        );

        return super.handleExceptionInternal(
                e,
                body,
                new HttpHeaders(),
                ErrorStatus.FOOD_CATEGORY_NOT_FOUND.getHttpStatus(),
                webRequest
        );
    }

    //RegionNotFoundException에 대한 에러 처리
    @ExceptionHandler(RegionNotFoundException.class)
    public ResponseEntity<Object> handleRegionNotFoundException(RegionNotFoundException e, HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);

        ApiResponse<Object> body = ApiResponse.onFailure(
                ErrorStatus.REGION_NOT_FOUND.getCode(),
                ErrorStatus.REGION_NOT_FOUND.getMessage(),
                null
        );

        return super.handleExceptionInternal(
                e,
                body,
                new HttpHeaders(),
                ErrorStatus.REGION_NOT_FOUND.getHttpStatus(),
                webRequest
        );
    }

    @ExceptionHandler(MissionNotFoundException.class)
    public ResponseEntity<Object> handleMissionNotFoundException(MissionNotFoundException e, HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);

        ApiResponse<Object> body = ApiResponse.onFailure(
                ErrorStatus.MISSION_NOT_FOUND.getCode(),
                ErrorStatus.MISSION_NOT_FOUND.getMessage(),
                null
        );

        return super.handleExceptionInternal(
                e,
                body,
                new HttpHeaders(),
                ErrorStatus.MISSION_NOT_FOUND.getHttpStatus(),
                webRequest
        );
    }


    @ExceptionHandler(MissionAlreadyInProgressException.class)
    public ResponseEntity<Object> handleMissionAlreadyInProgressException(MissionAlreadyInProgressException e, HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);

        ApiResponse<Object> body = ApiResponse.onFailure(
                ErrorStatus.MISSION_ALREADY_IN_PROGRESS.getCode(),
                ErrorStatus.MISSION_ALREADY_IN_PROGRESS.getMessage(),
                null
        );

        return super.handleExceptionInternal(
                e,
                body,
                new HttpHeaders(),
                ErrorStatus.MISSION_ALREADY_IN_PROGRESS.getHttpStatus(),
                webRequest
        );
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<Object> handleMemberNotFoundException(MemberNotFoundException e, HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);

        ApiResponse<Object> body = ApiResponse.onFailure(
                ErrorStatus.MEMBER_NOT_FOUND.getCode(),
                ErrorStatus.MEMBER_NOT_FOUND.getMessage(),
                null
        );

        return super.handleExceptionInternal(
                e,
                body,
                new HttpHeaders(),
                ErrorStatus.MEMBER_NOT_FOUND.getHttpStatus(),
                webRequest
        );
    }

    @ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<Object> handleStoreNotFoundException(StoreNotFoundException e, HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);

        ApiResponse<Object> body = ApiResponse.onFailure(
                ErrorStatus.STORE_NOT_FOUND.getCode(),
                ErrorStatus.STORE_NOT_FOUND.getMessage(),
                null
        );

        return super.handleExceptionInternal(
                e,
                body,
                new HttpHeaders(),
                ErrorStatus.STORE_NOT_FOUND.getHttpStatus(),
                webRequest
        );
    }

    private ResponseEntity<Object> handleExceptionInternal(Exception e, ErrorReasonDTO reason,
                                                           HttpHeaders headers, HttpServletRequest request) {

        ApiResponse<Object> body = ApiResponse.onFailure(reason.getCode(),reason.getMessage(),null);
//        e.printStackTrace();

        WebRequest webRequest = new ServletWebRequest(request);
        return super.handleExceptionInternal(
                e,
                body,
                headers,
                reason.getHttpStatus(),
                webRequest
        );
    }

    private ResponseEntity<Object> handleExceptionInternalFalse(Exception e, ErrorStatus errorCommonStatus,
                                                                HttpHeaders headers, HttpStatus status, WebRequest request, String errorPoint) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorCommonStatus.getCode(),errorCommonStatus.getMessage(),errorPoint);
        return super.handleExceptionInternal(
                e,
                body,
                headers,
                status,
                request
        );
    }

    private ResponseEntity<Object> handleExceptionInternalArgs(Exception e, HttpHeaders headers, ErrorStatus errorCommonStatus,
                                                               WebRequest request, Map<String, String> errorArgs) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorCommonStatus.getCode(),errorCommonStatus.getMessage(),errorArgs);
        return super.handleExceptionInternal(
                e,
                body,
                headers,
                errorCommonStatus.getHttpStatus(),
                request
        );
    }

    private ResponseEntity<Object> handleExceptionInternalConstraint(Exception e, ErrorStatus errorCommonStatus,
                                                                     HttpHeaders headers, WebRequest request) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorCommonStatus.getCode(), errorCommonStatus.getMessage(), null);
        return super.handleExceptionInternal(
                e,
                body,
                headers,
                errorCommonStatus.getHttpStatus(),
                request
        );
    }
}
