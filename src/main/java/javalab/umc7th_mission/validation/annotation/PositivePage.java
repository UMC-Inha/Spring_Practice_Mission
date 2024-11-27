package javalab.umc7th_mission.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import javalab.umc7th_mission.validation.validator.MemberExistValidator;
import javalab.umc7th_mission.validation.validator.PositivePageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PositivePageValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface PositivePage {

    String message() default "잘못된 페이지 번호를 입력하였습니다. 페이지는 최소 1이상 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
