package javalab.umc7th_mission.study.repository.RestaurantRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.repository.RestaurantRepository.RestaurantRepositoryCustom;

public interface RestaurantRepository extends  JpaRepository<Restaurant, Long>, RestaurantRepositoryCustom {
}
