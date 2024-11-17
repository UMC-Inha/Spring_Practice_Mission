package javalab.umc7th_mission.domain.mission.repository;


import static umc.umcjpaproject.domain.membermission.QMemberMission.memberMission;
import static umc.umcjpaproject.domain.mission.QMission.mission;
import static umc.umcjpaproject.domain.store.QStore.store;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MissionCustomRepositoryImpl implements CustomMissionRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Tuple> missionOne(Long userId, int limit, int offset) {
        return queryFactory
                .select(
                        mission.missionSpec,
                        mission.reward,
                        memberMission.createdAt)
                .from(mission)
                .join(mission.store, store)
                .join(memberMission).on(mission.id.eq(memberMission.mission.id))
                .where(
                        memberMission.member.id.eq(userId)
                                .and(memberMission.status.in(MissionStatus.CHALLENGING,
                                        MissionStatus.COMPLETE))
                )
                .orderBy(memberMission.createdAt.desc(), mission.id.asc(),
                        memberMission.member.id.asc())
                .limit(limit)
                .offset(offset)
                .fetch();
    }

    @Override
    public List<Tuple> missionThree(Long regionId, int limit, int offset) {
        return queryFactory
                .select(
                        store.name,
                        store.address,
                        mission.missionSpec,
                        mission.reward,
                        mission.deadLine)
                .from(mission)
                .join(mission.store, store)
                .leftJoin(memberMission).on(mission.id.eq(memberMission.mission.id))
                .where(memberMission.member.id.isNull()
                        .and(store.region.id.eq(regionId))
                        .and(mission.deadLine.after(LocalDateTime.now())))
                .orderBy(memberMission.createdAt.asc(), mission.id.asc(),
                        memberMission.member.id.asc())
                .limit(limit)
                .offset(offset)
                .fetch();
    }


}


