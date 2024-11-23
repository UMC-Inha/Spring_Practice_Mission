package javalab.umc7th_mission.service.MissionService;

import javalab.umc7th_mission.converter.MissionConverter;
import javalab.umc7th_mission.converter.ReviewConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.repository.MissionRepository.MissionRepository;
import javalab.umc7th_mission.service.StoreService.StoreQueryService;
import javalab.umc7th_mission.web.dto.mission.MissionRequestDTO;
import javalab.umc7th_mission.web.dto.review.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final MissionRepository missionRepository;
    private final StoreQueryService storeQueryService;

    @Override
    public Mission save(MissionRequestDTO.SaveDTO request) {
        Mission newMission = MissionConverter.toMission(request);
        Store store = storeQueryService.findStore(request.getStoreId());
        newMission.setStore(store);

        return missionRepository.save(newMission);
    }
}
