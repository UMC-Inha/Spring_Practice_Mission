package javalab.umc7th_mission.domain.membermission;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import javalab.umc7th_mission.domain.common.BaseEntity;
import javalab.umc7th_mission.domain.member.Member;
import javalab.umc7th_mission.domain.mission.Mission;
import javalab.umc7th_mission.domain.mission.MissionStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_mission_id")
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(15)")
    @Enumerated(STRING)
    private MissionStatus status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Builder
    public MemberMission(MissionStatus status, Member member, Mission mission) {
        this.status = status;
        this.member = member;
        this.mission = mission;
    }

}
