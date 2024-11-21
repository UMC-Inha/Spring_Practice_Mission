package javalab.umc7th_mission.study.repository.RestaurantRepository;

import javalab.umc7th_mission.study.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
