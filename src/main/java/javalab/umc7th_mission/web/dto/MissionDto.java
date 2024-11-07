package javalab.umc7th_mission.web.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class MissionDto {
    private Integer reward;
    private LocalDateTime deadline;
    private String missionSpec;
}
