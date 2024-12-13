package umc.spring.domain.mapping;



import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.MissionStatus;

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
    @Column(nullable = false, length = 15)
    private MissionStatus status;

    //오류 수정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @Builder
    public MemberMission(Member member, Mission mission, MissionStatus status) {
        this.member = member;
        this.mission = mission;
        this.status = status;
    }

    // Setter를 대신하는 빌더로 새로운 객체 생성
    public static MemberMission create(Member member, Mission mission, MissionStatus status) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(status)
                .build();
    }

    // 미션 완료 처리
    public void complete() {
        this.status = MissionStatus.COMPLETE;
    }

}
