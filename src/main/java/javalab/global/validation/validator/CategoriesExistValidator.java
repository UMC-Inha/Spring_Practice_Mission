package javalab.global.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.global.apiPayload.code.status.ErrorStatus;
import javalab.global.validation.annotation.ExistCategories;
import javalab.umc7th_mission.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

    private final CategoryRepository categoryRepository;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> longs, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = longs.stream()
                .allMatch(value -> categoryRepository.existsById(value));

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.CATEGORY_NOT_FOUND.toString())
                    .addConstraintViolation();
        }
        return isValid;
    }
}
