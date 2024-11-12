package javalab.umc7th_mission.domain.mission.repository;

import com.querydsl.core.Tuple;
import java.util.List;

public interface CustomMissionRepository {

    List<Tuple> missionOne(Long userId, int limit, int offset);

    List<Tuple> missionThree(Long regionId, int limit, int offset);

}

