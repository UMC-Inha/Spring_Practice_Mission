package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.FoodCategory;
import javalab.umc7th_mission.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(f -> MemberPrefer.builder()
                                .foodCategory(f)
                                .build()
                        ).collect(Collectors.toList());
    }
}
