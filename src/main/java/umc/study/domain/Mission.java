package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    private String missionSpec;

    private Long reward;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store storeId;

    public Mission(Long id, String name, String missionSpec, Long reward, Long completedMissionsCount) {
        this.id = id;
        this.name = name;
        this.missionSpec = missionSpec;
        this.reward = reward;
        this.completedMissionsCount = completedMissionsCount;
    }


    @Transient
    private Long completedMissionsCount;

    @Override
    public String toString() {
        return "Mission{" +
                "reward=" + reward +
                ", missionSpec='" + missionSpec + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
