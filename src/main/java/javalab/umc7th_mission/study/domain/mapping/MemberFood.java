package javalab.umc7th_mission.study.domain.mapping;

import jakarta.persistence.*;
import javalab.umc7th_mission.study.domain.common.BaseEntity;
import lombok.*;
import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.domain.Food;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberFood extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    public void setMember(Member member){
        if(this.member != null)
            member.getMemberFoodList().remove(this);
        this.member = member;
        member.getMemberFoodList().add(this);
    }

    public void setFood(Food food){
        this.food = food;
    }
}
