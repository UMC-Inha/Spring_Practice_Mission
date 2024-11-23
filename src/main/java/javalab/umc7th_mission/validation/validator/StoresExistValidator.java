package javalab.umc7th_mission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.service.MemberMissionService.MemberMissionCommandService;
import javalab.umc7th_mission.service.StoreService.StoreQueryService;
import javalab.umc7th_mission.validation.annotation.ExistStores;
import javalab.umc7th_mission.web.dto.review.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoresExistValidator implements ConstraintValidator<ExistStores, ReviewRequestDTO.SaveDTO> {
    private final StoreQueryService storeQueryService;

    @Override
    public void initialize(ExistStores constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ReviewRequestDTO.SaveDTO request, ConstraintValidatorContext context) {
        Store store = storeQueryService.findStore(request.getStoreId());

        if (store == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
