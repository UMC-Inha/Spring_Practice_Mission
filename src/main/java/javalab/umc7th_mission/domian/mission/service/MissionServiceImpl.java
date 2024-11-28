package javalab.umc7th_mission.domian.mission.service;

import javalab.umc7th_mission.domian.mission.dto.MissionRequest;
import javalab.umc7th_mission.domian.mission.dto.MissionResponse;
import javalab.umc7th_mission.domian.mission.dto.MissionResponse.addMissionByStatus;
import javalab.umc7th_mission.domian.mission.repository.MissionRepository;
import javalab.umc7th_mission.domian.store.dto.StoreResponse.CreateMissionToStore;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class MissionServiceImpl implements MissionService{

    private final MissionRepository missionRepository;
    @Override
    public addMissionByStatus ActiveMission(MissionRequest.addMissionByStatusDTO addMissionByStatusDTO){




        return addMissionByStatus.builder()
            .inSuccess("ok")
            .build();
    }
}
