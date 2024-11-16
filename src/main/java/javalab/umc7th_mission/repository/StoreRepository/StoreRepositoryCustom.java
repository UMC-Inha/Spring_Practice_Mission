package javalab.umc7th_mission.repository.StoreRepository;

import javalab.umc7th_mission.web.dto.MissionDto;
import java.util.List;

public interface StoreRepositoryCustom {
    List<MissionDto> findMissionsByRegionId(Long regionId);
}