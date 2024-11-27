package javalab.umc7th_mission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.validation.annotation.PositivePage;

public class PositivePageValidator implements ConstraintValidator<PositivePage, Integer> {
    @Override
    public void initialize(PositivePage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null) {
            return false;
        }

        if (page <= 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_OUT_OF_RANGE.toString())
                    .addConstraintViolation();
        }

        return page > 0;
    }
}
