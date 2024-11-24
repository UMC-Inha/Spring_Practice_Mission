package javalab.umc7th_mission.study.validation.validatior;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.umc7th_mission.study.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.study.service.MemberMissionService.MemberMissionCommandService;
import javalab.umc7th_mission.study.validation.annotation.IsMemberMissionNotStarted;
import javalab.umc7th_mission.study.web.dto.member_mission.MemberMissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IsMemberMissionNotStartedValidator implements ConstraintValidator<IsMemberMissionNotStarted, MemberMissionRequestDTO.AddMemberMissionDto> {
    private final MemberMissionCommandService memberMissionCommandService;
    @Override
    public void initialize(IsMemberMissionNotStarted constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO.AddMemberMissionDto request, ConstraintValidatorContext context) {
        boolean isValid = memberMissionCommandService.isExist(request.getMemberId(), request.getMissionId());

        if(isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_ALREADY_IN_CHALLENGING.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }

}
