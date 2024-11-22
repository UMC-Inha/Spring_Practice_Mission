package javalab.umc7th_mission.domain.mission;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import javalab.umc7th_mission.domain.common.BaseEntity;
import javalab.umc7th_mission.domain.store.Store;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "mission_id")
    private Long id;

    @Column(nullable = false)
    private Integer reward;

    @Column(nullable = false)
    private LocalDateTime deadLine;

    @Lob
    private String missionSpec;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    public Mission(Integer reward, LocalDateTime deadLine, String missionSpec, Store store) {
        this.reward = reward;
        this.deadLine = deadLine;
        this.missionSpec = missionSpec;
        this.store = store;
    }
}
