package javalab.umc7th_mission.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;
import javalab.umc7th_mission.validation.validator.PageValidator;

@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PageValidator.class)
public @interface CheckPage {
    String message() default "page 번호가 잘못되었습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
