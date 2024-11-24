package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MissionChallengeValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 커스텀 어노테이션 정의
@Constraint(validatedBy = MissionChallengeValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionChallengeValidation {
    String message() default "이미 도전 중인 미션입니다."; // 기본 오류 메시지

    Class<?>[] groups() default {}; // 그룹

    Class<? extends Payload>[] payload() default {}; // 추가적인 메타데이터
}
