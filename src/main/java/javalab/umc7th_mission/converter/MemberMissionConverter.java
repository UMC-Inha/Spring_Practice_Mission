package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.web.dto.MemberMissionRequestDTO;
import javalab.umc7th_mission.web.dto.MemberMissionResponseDTO;
import javalab.umc7th_mission.web.dto.MissionRequestDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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
    
    //24.11.27 ChallengingMission 조회 관련 컨버터 추가
    public static MemberMissionResponseDTO.ChallengingMissionPreviewDTO challengingMissionPreviewDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.ChallengingMissionPreviewDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionId(memberMission.getMission().getId())
                .missionName(memberMission.getMission().getName())
                .missionDescription(memberMission.getMission().getDescription())
                .reward(memberMission.getMission().getReward())
                .startDate(memberMission.getStartDate())
                .endDate(memberMission.getEndDate())
                .build();
    }

    public static MemberMissionResponseDTO.ChallengingMissionPreviewListDTO challengingMissionPreviewListDTO(Page<MemberMission> memberMissions) {
        // 1. MemberMission -> ChallengingMissionPreviewDTO 리스트 변환
        List<MemberMissionResponseDTO.ChallengingMissionPreviewDTO> challengingMissionList = memberMissions.stream()
                .map(MemberMissionConverter::challengingMissionPreviewDTO) // DTO 변환 메서드 호출
                .toList();

        // 2. 페이징 정보와 함께 ChallengingMissionPreviewListDTO 생성
        return MemberMissionResponseDTO.ChallengingMissionPreviewListDTO.builder()
                .challengingMissionList(challengingMissionList)
                .listSize(memberMissions.getSize())
                .totalPage(memberMissions.getTotalPages())
                .totalElements(memberMissions.getTotalElements())
                .isFirstPage(memberMissions.isFirst())
                .isLastPage(memberMissions.isLast())
                .build();

    }

    //24.11.27 completeMission 변환 로직 처리 메서드 추가
    public static MemberMissionResponseDTO.CompleteMissionResponseDTO toCompleteMissionResponseDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.CompleteMissionResponseDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionName(memberMission.getMission().getName())
                .missionStatus(memberMission.getStatus())
                .build();
    }
}