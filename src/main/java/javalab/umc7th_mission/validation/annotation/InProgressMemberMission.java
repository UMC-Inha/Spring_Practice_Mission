package javalab.umc7th_mission.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import javalab.umc7th_mission.validation.validator.CategoriesExistValidator;
import javalab.umc7th_mission.validation.validator.MemberMissionInProgressValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberMissionInProgressValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InProgressMemberMission {
    String message() default "이미 도전 중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
