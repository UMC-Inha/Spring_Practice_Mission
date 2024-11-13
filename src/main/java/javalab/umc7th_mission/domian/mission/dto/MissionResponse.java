package study.domian.mission.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MissionResponse {

    public class MissionStatusDto {

        private Long id;         // 미션 ID
        private int reward;      // 미션 보상
        private int state;       // 미션 상태 (1: 진행 중, 2: 진행 완료)
        private String content;  // 미션 내용
    }

    public class MissionRegoinDTO {

        private Long id;
        private Integer lowerPrice;
        private Integer reward;
        private LocalDateTime deadline;
        private String storeName;
        private String storeInfo;
    }
}