package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.FoodCategory;
import javalab.umc7th_mission.domain.mapping.StoreCategory;

import java.util.List;
import java.util.stream.Collectors;

public class StoreCategoryConverter {
    public static List<StoreCategory> toStoreCategoryList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        StoreCategory.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}