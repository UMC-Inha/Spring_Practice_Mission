package javalab.umc7th_mission.service.StoreCommandService;

import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    // 가게 저장
    Store addStore(StoreRequestDTO.AddDto request);
}
