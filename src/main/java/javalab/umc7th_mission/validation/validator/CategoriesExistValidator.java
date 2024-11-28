package javalab.umc7th_mission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import javalab.umc7th_mission.apipayload.code.status.ErrorStatus;
import javalab.umc7th_mission.domian.foodcategory.FoodCategory;
import javalab.umc7th_mission.domian.foodcategory.service.FoodCategoryService;
import javalab.umc7th_mission.validation.annotation.ExistCategories;
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

        List<FoodCategory> foodCategories=service.getByIds(values);
        boolean isValid = foodCategories.size() == values.size();

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
