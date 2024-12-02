package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.web.dto.MissionRequestDTO;
import javalab.umc7th_mission.web.dto.MissionResponseDTO;
import javalab.umc7th_mission.web.dto.ReviewResponseDTO;
import org.springframework.data.domain.Page;

import javax.sound.sampled.ReverbType;
import java.util.ArrayList;
import java.util.List;

public class MissionConverter {

    public static MissionResponseDTO.AddResultDTO toAddResultDTO(Mission mission) {
        return new MissionResponseDTO.AddResultDTO(
                mission.getId(),
                mission.getCreatedAt()
        );
    }

    public static Mission toMission(Store store, MissionRequestDTO.AddDTO request) {
        return Mission.builder()
                .store(store)
                .name(request.getName())
                .description(request.getDescription())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .reward(request.getReward())
                .build();
    }

    //24.11.27 MissionPreview 관련 컨버터 추가 (빌더 패턴 적용)
    public static MissionResponseDTO.MissionPreviewDTO missionPreviewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .missionId(mission.getId())
                .missionName(mission.getName())
                .description(mission.getDescription())
                .reward(mission.getReward())
                .isActive(mission.isActive())
                .startDate(mission.getStartDate())
                .endDate(mission.getEndDate())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<Mission> missionList) {
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(MissionConverter::missionPreviewDTO).toList();

        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .missionList(missionPreviewDTOList)
                .listSize(missionPreviewDTOList.size())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .isFirstPage(missionList.isFirst())
                .isLastPage(missionList.isLast())
                .build();
    }
}