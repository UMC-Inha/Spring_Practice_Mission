package javalab.umc7th_mission.service.FoodCategoryService;

import javalab.umc7th_mission.repository.FoodCategoryRepository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService {

    FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean allCategoriesExist(List<Long> values) {
        return values.stream()
                .allMatch(id -> foodCategoryRepository.existsById(id));
    }
}
