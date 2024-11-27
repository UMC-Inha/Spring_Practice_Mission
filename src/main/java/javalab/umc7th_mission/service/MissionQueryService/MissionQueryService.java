package javalab.umc7th_mission.service.MissionQueryService;

import javalab.umc7th_mission.domain.Mission;
import org.springframework.data.domain.Page;

public interface MissionQueryService {
    Page<Mission> getMissions (Long storeId, Integer page);
}
