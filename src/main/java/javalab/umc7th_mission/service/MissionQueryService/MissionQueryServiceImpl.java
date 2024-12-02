package javalab.umc7th_mission.service.MissionQueryService;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.repository.MissionRepository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> getMissions(Long storeId, Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("createdAt").descending());
        Page<Mission> missionPage = missionRepository.findMissionsByStoreId(storeId, pageRequest);
        return missionPage;
    }
}
