package javalab.umc7th_mission.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.repository.MemberMissionRepository.MemberMissionRepository;
import javalab.umc7th_mission.service.MemberMissionCommandService.MemberMissionCommandService;
import javalab.umc7th_mission.validation.annotation.ExistStore;
import javalab.umc7th_mission.validation.annotation.MissionNotInProgress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MissionNotInProgressValidator implements ConstraintValidator<MissionNotInProgress, Long> {
    private final MemberMissionCommandService memberMissionCommandService;
    @Override
    public void initialize(MissionNotInProgress constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        if (missionId == null) {
            return true; // 미션 ID가 없으면 검증을 통과시킴
        }

        //원래 현재 로그인한 사용자의 ID를 가져와야됨
        //현재는 로그인 기능이 없으니 하드코딩
        Long memberId = 1L;

        // 특정 회원이 해당 미션을 진행 중인지 확인
        boolean isInProgress = memberMissionCommandService.isMissionInProgress(memberId, missionId);
        if (isInProgress) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_IN_PROGRESS.toString())
                    .addConstraintViolation();
        }
        return !isInProgress;
    }
}
