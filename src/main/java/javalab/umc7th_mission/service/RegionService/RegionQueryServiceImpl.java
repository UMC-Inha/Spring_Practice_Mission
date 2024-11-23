package javalab.umc7th_mission.service.RegionService;

import javalab.umc7th_mission.domain.Region;
import javalab.umc7th_mission.repository.RegionRepository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionQueryServiceImpl implements RegionQueryService {
    private final RegionRepository regionRepository;

    @Override
    public Region find(Long regionId) {
        Region region = regionRepository.findById(regionId).orElseThrow();
        return region;
    }
}
