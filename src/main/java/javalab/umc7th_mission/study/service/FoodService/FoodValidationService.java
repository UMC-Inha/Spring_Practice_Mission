package javalab.umc7th_mission.study.service.FoodService;

import java.util.List;

public interface FoodValidationService {
    boolean allCategoriesExist(List<Long> values);
}
