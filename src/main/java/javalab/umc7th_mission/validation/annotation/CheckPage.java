package javalab.umc7th_mission.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import javalab.umc7th_mission.validation.validator.CategoriesExistValidator;
import javalab.umc7th_mission.validation.validator.CheckPageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "페이징 번호가 올바르지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}