package javalab.umc7th_mission.study.validation.validatior;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.umc7th_mission.study.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.repository.RestaurantRepository.RestaurantRepository;
import javalab.umc7th_mission.study.service.RestaurantService.RestaurantValidationService;
import javalab.umc7th_mission.study.validation.annotation.ExistCategories;
import javalab.umc7th_mission.study.validation.annotation.ExistRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurant,  Long> {
    private final RestaurantValidationService restaurantValidationService;

    @Override
    public void initialize(ExistRestaurant constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        boolean isValid = restaurantValidationService.findRestaurant(id).isPresent();

        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }


}
