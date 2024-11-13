package javalab.umc7th_mission.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import  javalab.umc7th_mission.study.domain.Member;
import  javalab.umc7th_mission.study.domain.Mission;
import  javalab.umc7th_mission.study.domain.common.BaseEntity;
import  javalab.umc7th_mission.study.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private MissionStatus status;

    @Column(nullable = false)
    private Integer bossNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
