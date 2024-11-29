package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Restaurant;
import javalab.umc7th_mission.domain.enums.Status;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.web.dto.request.MissionRequestDTO;
import javalab.umc7th_mission.web.dto.response.MissionResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MissionConverter {

    public Mission toEntity(MissionRequestDTO.AddMission request, Restaurant restaurant) {
        return Mission.builder()
                .restaurant(restaurant)
                .content(request.getContent())
                .reward(request.getReward())
                .build();
    }

    public MissionResponseDTO.AddMission toAddMissionResponse(Mission mission) {
        return MissionResponseDTO.AddMission.builder()
                .missionId(mission.getId())
                .restaurantId(mission.getRestaurant().getId())
                .createdAt(mission.getCreateAt())
                .build();
    }

    public MemberMission toMMEntity(MissionRequestDTO.ActiveMission request, Member member,Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(Status.ACTIVE)
                .classificationNumber(request.getClassificationNumber())
                .deadline(request.getDeadline())
                .build();
    }

    public MissionResponseDTO.ActiveMission toActiveMission(MemberMission memberMission) {
        return MissionResponseDTO.ActiveMission.builder()
                .missionId(memberMission.getMission().getId())
                .deadline(memberMission.getDeadline())
                .build();
    }
}
