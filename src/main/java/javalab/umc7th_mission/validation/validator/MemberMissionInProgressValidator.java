package javalab.umc7th_mission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.service.MemberMissionService.MemberMissionCommandService;
import javalab.umc7th_mission.validation.annotation.InProgressMemberMission;
import javalab.umc7th_mission.web.dto.member_mission.MemberMissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MemberMissionInProgressValidator implements ConstraintValidator<InProgressMemberMission, MemberMissionRequestDTO.SaveDTO>{
    private final MemberMissionCommandService memberMissionCommandService;

    @Override
    public void initialize(InProgressMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO.SaveDTO request, ConstraintValidatorContext context) {
        boolean isValid = memberMissionCommandService.isExist(request.getMemberId(), request.getMissionId());

        if (isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_ALREADY_IN_PROGRESS.toString()).addConstraintViolation();
            return false;
        }

        return true;
    }
}
