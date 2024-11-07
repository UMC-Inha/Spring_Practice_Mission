package javalab.umc7th_mission.domain;
import jakarta.persistence.*;
import javalab.umc7th_mission.domain.common.BaseEntity;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private Integer reward;

    @ManyToOne(fetch = FetchType.LAZY)
    /*
    FetchType.LAZY의 장단점
    1. 성능 최적화: 필요할 때만 연관 데이터를 로딩 -> 불필요한 쿼리 실행수 줄일 수 있음
    2. 메모리 효율성: 여러개의 ManyToOne 관계를 가진 엔티티에서, 지연로딩을 통해 메모리 최소화
    3. 순환 참조 방지: 지연 로딩을 통해 방지
     */
    @JoinColumn(name = "store_id", referencedColumnName = "id", nullable = false)
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
