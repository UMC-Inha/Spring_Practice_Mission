package javalab.umc7th_mission.service.MemberMissionService;

import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.apiPayload.exception.GeneralException;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.repository.MemberMissionRepository.MemberMissionRepository;
import javalab.umc7th_mission.service.MemberService.MemberQueryService;
import javalab.umc7th_mission.service.MissionService.MissionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberQueryService memberQueryService;
    private final MissionQueryService missionQueryService;

    @Override
    public MemberMission start(Long memberId, Long missionId) {
        Member member = memberQueryService.findMember(memberId);
        Mission mission = missionQueryService.findMission(missionId);

        MemberMission newMemberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.IN_PROGRESS)
                .build();

        return memberMissionRepository.save(newMemberMission);
    }

    @Override
    @Transactional
    public MemberMission done(Long memberId, Long missionId) {
        if (memberMissionRepository.updateStatusToDone(memberId, missionId) == 0) {
            throw new GeneralException(ErrorStatus.MEMBER_MISSION_NOT_IN_PROGRESS);
        }
        return memberMissionRepository.findMemberMissionByMemberIdAndMissionId(memberId, missionId);
    }

    public Boolean isExist(Long memberId, Long missionId) {
        MemberMission result = memberMissionRepository.findMemberMissionByMemberIdAndMissionId(memberId, missionId);
        if (result != null && result.getStatus() == MissionStatus.IN_PROGRESS) {
            return true;
        }
        return false;
    }
}
