package javalab.umc7th_mission.repository.mission;

import java.util.List;
import study.domian.mission.dto.MissionRequest.MissionRegoinDTO;
import study.domian.mission.dto.MissionRequest.MissionStatusDto;

public interface MissionCustomRepository {

    public List<MissionStatusDto> FindMissionByStatus(Long userId, int limit, int offset);
    public List<MissionRegoinDTO> findMissionByRegoin(Long userId, int limit, int offset);
}
