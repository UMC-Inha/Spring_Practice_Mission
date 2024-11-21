package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.web.dto.MemberMissionRequestDTO;
import javalab.umc7th_mission.web.dto.MemberMissionResponseDTO;
import javalab.umc7th_mission.web.dto.MissionRequestDTO;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.AddResultDTO toAddResultDTO(MemberMission memberMission) {
        return new MemberMissionResponseDTO.AddResultDTO(
                memberMission.getId(),
                memberMission.getCreatedAt()
        );
    }

    public static MemberMission toMemberMission(Member member, Mission mission, MemberMissionRequestDTO.AddDTO request) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
