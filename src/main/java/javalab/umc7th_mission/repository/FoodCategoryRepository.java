package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.foodCategory;

public interface FoodCategoryRepository extends JpaRepository<foodCategory, Long> {
}
