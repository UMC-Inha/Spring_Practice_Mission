package javalab.umc7th_mission.service;

import javalab.global.apiPayload.code.status.ErrorStatus;
import javalab.global.apiPayload.exception.GeneralException;
import javalab.umc7th_mission.converter.MissionConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Restaurant;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.repository.MemberMissionRepository;
import javalab.umc7th_mission.repository.MemberRepository;
import javalab.umc7th_mission.repository.MissionRepository;
import javalab.umc7th_mission.repository.RestaurantRepository;
import javalab.umc7th_mission.web.dto.request.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionConverter missionConverter;
    private final MissionRepository missionRepository;
    private final RestaurantRepository restaurantRepository;
    private final MemberService memberService;
    private final MemberMissionRepository memberMissionRepository;

    public Mission addMission(MissionRequestDTO.AddMission request, Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND_BY_ID)
        );

        Mission mission = missionConverter.toEntity(request, restaurant);
        missionRepository.save(mission);
        restaurant.getMissionList().add(mission);

        return mission;
    }

    public MemberMission activeMission(MissionRequestDTO.ActiveMission request) {
        Member member = memberService.findMember(request.getMemberId());
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(
                () -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND_BY_ID)
        );

        MemberMission memberMission = missionConverter.toMMEntity(request, member, mission);
        memberMissionRepository.save(memberMission);

        return memberMission;
    }
}
