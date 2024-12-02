package javalab.umc7th_mission.domain.mapping;

import jakarta.persistence.*;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.common.BaseEntity;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import lombok.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;


import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", referencedColumnName = "id")
    private Mission mission;

    //이건 assigned, completed가 좋을까? 네이밍의 고민
    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    //도전 중 -> 도전 완료 상태 변경
    public void complete() {
        if(this.status != MissionStatus.CHALLENGING) {
            throw new IllegalStateException("미션이 도전 중이 아닙니다.");
        }
        this.status = MissionStatus.COMPLETE;
    }
}
