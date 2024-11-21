package javalab.umc7th_mission.service.MemberMissionCommandService;

import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.apiPayload.exception.MemberNotFoundException;
import javalab.umc7th_mission.apiPayload.exception.MissionNotFoundException;
import javalab.umc7th_mission.converter.MemberMissionConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.repository.MemberMissionRepository.MemberMissionRepository;
import javalab.umc7th_mission.repository.MemberRepository.MemberRepository;
import javalab.umc7th_mission.repository.MissionRepository.MissionRepository;
import javalab.umc7th_mission.web.dto.MemberMissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMission addMemberMission(MemberMissionRequestDTO.AddDTO request) {
        //멤버 파악
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberNotFoundException(ErrorStatus.MEMBER_NOT_FOUND));

        //
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionNotFoundException(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission, request);

        return memberMissionRepository.save(memberMission);
    }

    @Override
    public boolean isMissionInProgress(Long memberId, Long missionId) {
        return memberMissionRepository.existsByMemberIdAndMissionIdAndStatus(memberId, missionId, MissionStatus.CHALLENGING);
    }

}
