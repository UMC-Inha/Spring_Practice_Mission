package javalab.umc7th_mission.domian.mission.service;

import javalab.umc7th_mission.apipayload.code.status.ErrorStatus;
import javalab.umc7th_mission.apipayload.exception.GeneralException;
import javalab.umc7th_mission.domian.enums.MissionStatus;
import javalab.umc7th_mission.domian.member.Member;
import javalab.umc7th_mission.domian.member.service.MemberService;
import javalab.umc7th_mission.domian.membermission.MemberMission;
import javalab.umc7th_mission.domian.membermission.repository.MemberMissionRepository;
import javalab.umc7th_mission.domian.mission.Mission;
import javalab.umc7th_mission.domian.mission.dto.MissionConverter;
import javalab.umc7th_mission.domian.mission.dto.MissionRequest;
import javalab.umc7th_mission.domian.mission.dto.MissionResponse;

import javalab.umc7th_mission.domian.mission.repository.MissionRepository;
import javalab.umc7th_mission.domian.store.Store;

import javalab.umc7th_mission.domian.store.repository.StoreRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class MissionServiceImpl implements MissionService{

    private final MissionRepository missionRepository;
    private final MissionConverter missionConverter;
    private final StoreRepository restaurantRepository;
    private final MemberService memberService;
    private final MemberMissionRepository memberMissionRepository;
    @Override
    public Mission addMission(MissionRequest.AddMission request, Long restaurantId) {
        Store restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
            () -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND_BY_ID)
        );

        Mission mission = missionConverter.toEntity(request, restaurant);
        missionRepository.save(mission);
        restaurant.getMissionList().add(mission);

        return mission;
    }
    @Override
    public MemberMission activeMission(MissionRequest.ActiveMission request) {
        Member member = memberService.findMember(request.getMemberId());
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(
            () -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND_BY_ID)
        );

        MemberMission memberMission = missionConverter.toMMEntity(request, member, mission);
        memberMissionRepository.save(memberMission);

        return memberMission;
    }

    @Override
    public MissionResponse.ActiveMissionList getActiveMissionList(Long memberId, Integer page) {
        Member member = memberService.findMember(memberId);
        Page<MemberMission> memberMissionPage = memberMissionRepository.findAllByMemberAndStatus(member, MissionStatus.CHALLENGING, PageRequest.of(page, 10));
        MissionResponse.ActiveMissionList missionInfoList = missionConverter.toMissionInfoList(memberMissionPage);

        return missionInfoList;
    }

    @Transactional
    @Override
    public MemberMission completeMission(Long mmId) {
        MemberMission memberMission = memberMissionRepository.findById(mmId).get();
        memberMission.setStatus(MissionStatus.COMPLETE);
        return memberMission;
    }
}
