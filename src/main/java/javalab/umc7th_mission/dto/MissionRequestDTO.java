package umc.spring.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MissionRequestDTO {
    private String missionSpec;
    private int reward;
    private LocalDate deadline;
    private Long storeId;
}