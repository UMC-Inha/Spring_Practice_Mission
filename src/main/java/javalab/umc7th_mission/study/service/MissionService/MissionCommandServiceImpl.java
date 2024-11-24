package javalab.umc7th_mission.study.service.MissionService;

import javalab.umc7th_mission.study.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.study.apiPayload.exception.GeneralException;
import javalab.umc7th_mission.study.converter.MissionConverter;
import javalab.umc7th_mission.study.domain.Mission;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.repository.MissionRepository.MissionRepository;
import javalab.umc7th_mission.study.repository.RestaurantRepository.RestaurantRepository;
import javalab.umc7th_mission.study.web.dto.mission.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;

    @Override
    public Mission AddMission(MissionRequestDTO.AddMissionDto request){
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.RESTAURANT_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, restaurant);

        return missionRepository.save(newMission);
    }
}
