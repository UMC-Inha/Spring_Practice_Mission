package javalab.umc7th_mission.study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import javalab.umc7th_mission.study.validation.validatior.IsMemberMissionNotStartedValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IsMemberMissionNotStartedValidator.class)
@Target( { ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsMemberMissionNotStarted {
    String message() default "해당 미션은 이미 진행중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
