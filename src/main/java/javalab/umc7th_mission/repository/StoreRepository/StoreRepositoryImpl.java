package javalab.umc7th_mission.repository.StoreRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.domain.QStore;
import ext.javalab.umc7th_mission.domain.QMission;
import javalab.umc7th_mission.web.dto.MissionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;
    private final QMission mission = QMission.mission;

    @Override
    public List<MissionDto> findMissionsByRegionId(Long regionId) {
        return jpaQueryFactory
                .select(Projections.constructor(
                        MissionDto.class,
                        mission.id,
                        mission.mission_spec,
                        store.name,
                        mission.reward)
                )
                .from(mission)
                .join(mission.store, store)
                .where(store.region.id.eq(regionId))
                .fetch();
    }
}