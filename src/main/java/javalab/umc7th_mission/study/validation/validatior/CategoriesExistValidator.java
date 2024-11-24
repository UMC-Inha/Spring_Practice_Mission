package javalab.umc7th_mission.study.validation.validatior;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.umc7th_mission.study.service.FoodService.FoodValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javalab.umc7th_mission.study.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.study.repository.RestaurantRepository.FoodRepository;
import javalab.umc7th_mission.study.validation.annotation.ExistCategories;


import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {
    private final FoodValidationService foodValidationService;

    @Override
    public void initialize(ExistCategories constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = foodValidationService.allCategoriesExist(values);

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
