package javalab.umc7th_mission.service.MissionService;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.repository.MissionRepository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;

    @Override
    public Mission findMission(Long missionId) {
        return missionRepository.findById(missionId).orElseThrow();
    }

}
