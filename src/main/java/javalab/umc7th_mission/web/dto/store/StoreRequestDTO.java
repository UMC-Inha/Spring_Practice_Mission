package javalab.umc7th_mission.web.dto.store;

import javalab.umc7th_mission.domain.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreRequestDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JoinDTO {
        private String name;
        private String address;
        private Long regionId;
    }
}
