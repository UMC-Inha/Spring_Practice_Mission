package umc.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class MissionResponseDTO {
    private Long id;
    private String missionSpec;
    private int reward;
    private LocalDate deadline;
    private String storeName;
}
