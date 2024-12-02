package javalab.global.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.global.validation.annotation.CheckPage;

public class PageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext constraintValidatorContext) {
        if (page == null) {
            return true;
        }

        return page >= 1;
    }
}
