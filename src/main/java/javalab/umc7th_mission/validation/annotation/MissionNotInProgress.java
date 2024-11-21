package javalab.umc7th_mission.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import javalab.umc7th_mission.repository.MemberMissionRepository.MemberMissionRepository;
import javalab.umc7th_mission.validation.validator.MissionNotInProgressValidator;


import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionNotInProgressValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionNotInProgress {
    String message() default "해당 ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
