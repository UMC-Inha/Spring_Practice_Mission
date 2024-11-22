package javalab.umc7th_mission.domain.memberprefer;

import java.util.List;
import javalab.umc7th_mission.domain.foodcategory.FoodCategory;
import javalab.umc7th_mission.domain.member.Member;

public final class MemberPreferConverter {

    private MemberPreferConverter() {
    }

    public static List<MemberPrefer> to(Member member, List<FoodCategory> foodCategories) {
        return foodCategories.stream()
                .map(foodCategory -> MemberPrefer.builder()
                        .member(member)
                        .foodCategory(foodCategory)
                        .build())
                .toList();
    }

}
