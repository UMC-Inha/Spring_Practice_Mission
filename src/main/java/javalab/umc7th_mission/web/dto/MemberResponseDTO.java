package javalab.umc7th_mission.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Join;

import java.time.LocalDateTime;


// @NoArgsConstructor -> 불변성 유지를 위해 생성자 여러개 제공 방지
public class MemberResponseDTO {
    public static class JoinResultDTO {
        private final Long memberId;
        private final LocalDateTime createdAt;

        public JoinResultDTO(Long memberId, LocalDateTime createdAt) {
            this.memberId = memberId;
            this.createdAt = createdAt;
        }

        // 명시적 Getter (Jackson 직렬화를 위해 필요)
        public Long getMemberId() {
            return memberId;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }
    }
}
