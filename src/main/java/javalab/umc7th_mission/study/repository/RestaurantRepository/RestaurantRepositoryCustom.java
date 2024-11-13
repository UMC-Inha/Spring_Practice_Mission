package javalab.umc7th_mission.study.repository.RestaurantRepository;

import javalab.umc7th_mission.study.domain.Restaurant;

import java.util.List;
public interface RestaurantRepositoryCustom {
    List<Restaurant> dynamicQueryWithBooleanBuilder(String name);
}
