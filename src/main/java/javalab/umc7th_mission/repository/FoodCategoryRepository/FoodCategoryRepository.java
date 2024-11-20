package javalab.umc7th_mission.repository.FoodCategoryRepository;

import javalab.umc7th_mission.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
