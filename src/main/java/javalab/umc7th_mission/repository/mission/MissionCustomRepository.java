package javalab.umc7th_mission.repository.mission;

import java.util.List;
import study.domian.mission.dto.MissionResponse.MissionRegoinDTO;
import study.domian.mission.dto.MissionResponse.MissionStatusDto;

public interface MissionCustomRepository {

    public List<MissionStatusDto> FindMissionByStatus(Long userId, int limit, int offset);
    public List<MissionRegoinDTO> findMissionByRegoin(Long userId,String addressName, int limit, int offset);
}
