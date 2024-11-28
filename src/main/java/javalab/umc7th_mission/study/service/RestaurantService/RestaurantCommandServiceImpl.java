package javalab.umc7th_mission.study.service.RestaurantService;

import javalab.umc7th_mission.study.converter.RestaurantConverter;
import javalab.umc7th_mission.study.domain.Region;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.domain.Review;
import javalab.umc7th_mission.study.repository.RegionRepository.RegionRepository;
import javalab.umc7th_mission.study.repository.RestaurantRepository.RestaurantRepository;
import javalab.umc7th_mission.study.repository.ReviewRepository.ReviewRepository;
import javalab.umc7th_mission.study.service.RegionService.RegionValidationService;
import javalab.umc7th_mission.study.web.dto.restaurant.RestaurantRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService{
    private final RestaurantRepository restaurantRepository;
    private final RegionValidationService regionValidationService;
    private final ReviewRepository reviewRepository;

    @Override
    public Restaurant AddRestaurant(RestaurantRequestDTO.AddRestaurantDto request){
        Region region = regionValidationService.findById(request.getRegionId());
        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request, region);
        return restaurantRepository.save(newRestaurant);

    }
}
