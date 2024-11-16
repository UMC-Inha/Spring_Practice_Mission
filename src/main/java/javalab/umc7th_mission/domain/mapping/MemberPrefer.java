package javalab.umc7th_mission.domain.mapping;
import jakarta.persistence.*;
import lombok.*;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.foodCategory;
import javalab.umc7th_mission.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private foodCategory foodCategory;
}
