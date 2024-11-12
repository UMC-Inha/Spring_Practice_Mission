package javalab.umc7th_mission.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class AvailableMissionDTO {
    private Long missionId;
    private String restaurant;
    private String content;
    private Integer point;
    private LocalDate deadline;
}
