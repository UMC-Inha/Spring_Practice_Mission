package javalab.umc7th_mission.config.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import javalab.umc7th_mission.config.apipayload.code.status.ErrorStatus;
import javalab.umc7th_mission.domain.foodcategory.FoodCategory;
import javalab.umc7th_mission.domain.foodcategory.service.FoodCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

    private final FoodCategoryService service;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        List<FoodCategory> foodCategories = service.getByIds(values);
        boolean isValid = foodCategories.size() == values.size();

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                            ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}