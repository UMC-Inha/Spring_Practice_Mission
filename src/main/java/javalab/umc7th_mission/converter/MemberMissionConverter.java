package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.web.dto.member_mission.MemberMissionResponseDTO;
import javalab.umc7th_mission.web.dto.mission.MissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.SaveResultDTO toSaveResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.SaveResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionId(memberMission.getMission().getId())
                .memberId(memberMission.getMember().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
