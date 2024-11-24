package javalab.umc7th_mission.study.service.FoodService;

import javalab.umc7th_mission.study.domain.Food;
import javalab.umc7th_mission.study.repository.RestaurantRepository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodValidationServiceImpl implements FoodValidationService{
    FoodRepository foodRepository;

    @Override
    public boolean allCategoriesExist(List<Long> values){
        return values.stream()
                .allMatch(id -> foodRepository.existsById(id));
    }
}
