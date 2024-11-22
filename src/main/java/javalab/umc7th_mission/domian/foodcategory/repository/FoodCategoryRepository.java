package javalab.umc7th_mission.domian.foodcategory.repository;

import java.util.List;
import javalab.umc7th_mission.domian.foodcategory.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {

    List<FoodCategory> findByIdIn(List<Long> ids);

}
