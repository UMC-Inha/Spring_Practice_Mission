package javalab.umc7th_mission.domain.mission.dto;

public record MissionResponseDto(
        Long missionId,
        Integer reward,
        String missionSpec,
        String storeName
) {

}

