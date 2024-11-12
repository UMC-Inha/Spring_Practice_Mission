package javalab.umc7th_mission.domain.mapping;

import jakarta.persistence.*;
import javalab.umc7th_mission.domain.AlarmTerms;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Terms;
import javalab.umc7th_mission.domain.common.BaseEntity;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberAlarm extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alarm_terms_id")
    private AlarmTerms alarmTerms;
}
