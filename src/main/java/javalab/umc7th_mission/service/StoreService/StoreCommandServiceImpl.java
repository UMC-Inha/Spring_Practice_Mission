package javalab.umc7th_mission.service.StoreService;

import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.apiPayload.exception.GeneralException;
import javalab.umc7th_mission.converter.MemberConverter;
import javalab.umc7th_mission.converter.MemberPreferConverter;
import javalab.umc7th_mission.converter.StoreConverter;
import javalab.umc7th_mission.domain.FoodCategory;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Region;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.domain.mapping.MemberPrefer;
import javalab.umc7th_mission.repository.StoreRepository.StoreRepository;
import javalab.umc7th_mission.service.RegionService.RegionQueryService;
import javalab.umc7th_mission.web.dto.member.MemberRequestDTO;
import javalab.umc7th_mission.web.dto.store.StoreRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final RegionQueryService regionQueryService;

    @Override
    public Store join(StoreRequestDTO.JoinDTO request) {
        Store newStore = StoreConverter.toStore(request);
        Region region = regionQueryService.find(request.getRegionId());
        newStore.setRegion(region);
        return storeRepository.save(newStore);
    }
}
