package javalab.umc7th_mission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.service.FoodCategoryService.FoodCategoryCommandService;
import javalab.umc7th_mission.validation.annotation.CheckPage;
import javalab.umc7th_mission.validation.annotation.ExistCategories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CheckPageValidator implements ConstraintValidator<CheckPage, Long> {
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = (value >= 1) ? true : false;

        if (value <= 0) {
            context.disableDefaultConstraintViolation();
            return false;
        }

        return true;
    }

}
