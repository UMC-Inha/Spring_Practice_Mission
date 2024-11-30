package javalab.umc7th_mission.study.validation.validatior;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.umc7th_mission.study.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.study.apiPayload.exception.GeneralException;
import javalab.umc7th_mission.study.validation.annotation.CheckPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {
    @Override
    public void initialize(CheckPage constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value<1){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_BOUND_ERROR.toString())
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

}
