package study.domian.mapping;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.domian.common.BaseEntity;
import study.domian.member.Member;
import study.domian.mission.Mission;
import study.domian.mission.Status;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="member_mission_id")
    private Long id;

    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
