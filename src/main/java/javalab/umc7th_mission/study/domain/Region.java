package javalab.umc7th_mission.study.domain;

import jakarta.persistence.*;
import javalab.umc7th_mission.study.domain.common.BaseEntity;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy="region", cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;
}
