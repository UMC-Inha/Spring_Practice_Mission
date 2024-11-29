package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.validation.annotation.PageValidation;

public class PageValidator implements ConstraintValidator<PageValidation, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value > 0; // 페이지 번호는 1 이상이어야 유효
    }
}
