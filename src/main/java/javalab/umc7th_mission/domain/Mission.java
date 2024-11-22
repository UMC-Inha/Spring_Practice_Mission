package javalab.umc7th_mission.domain;

import jakarta.persistence.*;
import javalab.global.entity.BaseEntity;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @Column(name = "mission_id")
    private Long id;

    @Column(nullable = false)
    private String content;

    private Long reward;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
