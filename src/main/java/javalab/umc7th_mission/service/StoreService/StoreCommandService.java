package javalab.umc7th_mission.service.StoreService;

import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.web.dto.store.StoreRequestDTO;

public interface StoreCommandService {
    Store join(StoreRequestDTO.JoinDTO request);
}
