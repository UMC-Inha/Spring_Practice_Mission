package javalab.umc7th_mission.domain;
import jakarta.persistence.*;
import lombok.*;
import javalab.umc7th_mission.domain.mapping.MemberAgree;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @Column(nullable = false)
    private Boolean optional;

    // 양방향 연관 관계
    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();
}
