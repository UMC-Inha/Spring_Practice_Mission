package javalab.umc7th_mission.service.MissionCommandService;

import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.apiPayload.exception.StoreNotFoundException;
import javalab.umc7th_mission.converter.MissionConverter;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.repository.MissionRepository.MissionRepository;
import javalab.umc7th_mission.repository.StoreRepository.StoreRepository;
import javalab.umc7th_mission.web.dto.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Mission addMission(MissionRequestDTO.AddDTO request) {
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreNotFoundException(ErrorStatus.STORE_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(store, request);
        return missionRepository.save(newMission);
    }
}