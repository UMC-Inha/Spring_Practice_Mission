package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.validation.annotation.MissionChallengeValidation;

@RequiredArgsConstructor
public class MissionChallengeValidator implements ConstraintValidator<MissionChallengeValidation, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        // 미션에 대해 도전 중인 상태가 있는지 확인
        boolean isMissionChallenging = memberMissionRepository.existsByMissionIdAndStatus(missionId, MissionStatus.CHALLENGING);
        return !isMissionChallenging; // 이미 도전 중인 미션은 실패로 처리
    }
}
