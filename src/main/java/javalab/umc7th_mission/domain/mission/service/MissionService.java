package javalab.umc7th_mission.domain.mission.service;

import javalab.umc7th_mission.domain.mission.dto.MissionResponseDto;
import javalab.umc7th_mission.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {

    private final MissionRepository repository;

    public Page<MissionResponseDto> getMissionsByStore(Long storeId, Pageable pageable) {
        return repository.findByStoreId(storeId, pageable)
                .map(mission -> new MissionResponseDto(
                        mission.getId(),
                        mission.getReward(),
                        mission.getMissionSpec(),
                        mission.getStore().getName()
                ));
    }
}
