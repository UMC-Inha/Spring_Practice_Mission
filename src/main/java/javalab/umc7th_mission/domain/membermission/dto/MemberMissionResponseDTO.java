package javalab.umc7th_mission.domain.membermission.dto;

public record MemberMissionResponseDTO(
        Long missionId,
        String missionSpec,
        Integer reward,
        String status,
        String storeName
) {

}
