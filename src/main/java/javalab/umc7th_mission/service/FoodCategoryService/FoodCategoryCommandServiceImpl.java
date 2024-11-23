package javalab.umc7th_mission.service.FoodCategoryService;

import javalab.umc7th_mission.repository.FoodCategoryRepository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodCategoryCommandServiceImpl implements FoodCategoryCommandService {
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Boolean isExist(Long id) {
        return foodCategoryRepository.existsById(id);
    }
}
