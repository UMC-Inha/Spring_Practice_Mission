package javalab.umc7th_mission.study.converter;

import javalab.umc7th_mission.study.domain.Food;
import javalab.umc7th_mission.study.domain.mapping.MemberFood;

import java.util.List;
import java.util.stream.Collectors;

public class MemberFoodConverter {
    public static List<MemberFood> toMemberFoodList(List<Food> foodList){
        return foodList.stream()
                .map(food -> MemberFood.builder()
                        .food(food)
                        .build()
                ).collect(Collectors.toList());
    }
}
