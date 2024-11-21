package javalab.umc7th_mission.study.service.RegionService;

import javalab.umc7th_mission.study.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.study.apiPayload.exception.GeneralException;
import javalab.umc7th_mission.study.domain.Region;
import javalab.umc7th_mission.study.repository.RegionRepository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionValidationServiceImpl implements RegionValidationService {
    private final RegionRepository regionRepository;

    @Override
    public Region findById(Long regionId){
        return regionRepository.findById(regionId).
                orElseThrow(() -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));
    }

}
