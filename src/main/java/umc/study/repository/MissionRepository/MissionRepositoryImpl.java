package umc.study.repository.MissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;

import java.util.List;

import static umc.study.domain.QMission.mission;
import static umc.study.domain.QStore.store;
import static umc.study.domain.QRegion.region;
import static umc.study.domain.mapping.QMemberMission.memberMission;


@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Mission> findMissionsWithCompletedCountByRegion(Long regionId) {
        return jpaQueryFactory
                .select(Projections.fields(Mission.class,
                        mission.id,
                        mission.name,
                        mission.missionSpec,
                        mission.reward,
                        memberMission.id.count().as("completedMissionsCount")
                ))
                .from(mission)
                .leftJoin(mission.storeId, store)
                .leftJoin(store.regionId, region)
                .leftJoin(memberMission).on(memberMission.missionId.id.eq(mission.id)
                        .and(memberMission.status.eq(MissionStatus.valueOf("SUCCESS"))))
                .where(region.id.eq(regionId))
                .groupBy(mission.id, mission.name, mission.missionSpec, mission.reward)
                .orderBy(mission.createdAt.desc())
                .fetch();
    }
}
