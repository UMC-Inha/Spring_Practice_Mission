package javalab.umc7th_mission.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionDto {
    private Long missionId;
    private String content;
    private String restaurantName;
    private Integer point;
}