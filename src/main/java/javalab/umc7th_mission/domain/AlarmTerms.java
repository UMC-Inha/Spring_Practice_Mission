package javalab.umc7th_mission.domain;

import jakarta.persistence.*;
import javalab.umc7th_mission.domain.common.BaseEntity;
import javalab.umc7th_mission.domain.mapping.MemberAgree;
import javalab.umc7th_mission.domain.mapping.MemberAlarm;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AlarmTerms extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean optional;
    //enum 타입으로.해도된다

    @Builder.Default
    @OneToMany(mappedBy = "alarmTerms", cascade = CascadeType.ALL)
    private List<MemberAlarm> memberAgreeList = new ArrayList<>();
}
