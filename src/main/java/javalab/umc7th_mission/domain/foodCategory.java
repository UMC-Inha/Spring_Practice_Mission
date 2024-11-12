package javalab.umc7th_mission.domain;

import jakarta.persistence.*;
import lombok.*;
import javalab.umc7th_mission.domain.mapping.MemberPrefer;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class foodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private String name;

    // 연관 관계
    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPrefers = new ArrayList<>();


}
