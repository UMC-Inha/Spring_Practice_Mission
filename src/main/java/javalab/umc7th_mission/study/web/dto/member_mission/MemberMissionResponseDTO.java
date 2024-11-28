package javalab.umc7th_mission.study.web.dto.member_mission;

import javalab.umc7th_mission.study.web.dto.mission.MissionResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberMissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMemberMissionResultDTO{
        Long memberMissionId;
        LocalDate createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengingMissionPreviewListDTO{
        List<MemberMissionResponseDTO.ChallengingMissionPreviewDTO> challengingMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengingMissionPreviewDTO{
        Long memberId;
        Long missionId;
        String name;
        String content;
        Integer point;
        LocalDate createdAt;
        LocalDate start;
        LocalDate end;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompletedResultDTO {
        Long memberMissionId;
        Long memberId;
        Long missionId;
        LocalDateTime updatedAt;
    }
}
