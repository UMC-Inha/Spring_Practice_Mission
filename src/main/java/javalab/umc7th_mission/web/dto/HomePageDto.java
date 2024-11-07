package javalab.umc7th_mission.web.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class HomePageDto {
    private String name;
    private String missionSpec;
    private LocalDateTime deadline;

}
