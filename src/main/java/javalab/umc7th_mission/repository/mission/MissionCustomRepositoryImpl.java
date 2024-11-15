package javalab.umc7th_mission.repository.mission;


import static study.domian.mapping.QMemberMission.memberMission;
import static study.domian.mission.QMission.mission;
import static study.domian.store.QStore.store;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.domian.mission.Status;
import study.domian.mission.dto.MissionResponse.*;


@RequiredArgsConstructor
@Repository
public class MissionCustomRepositoryImpl implements MissionCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MissionStatusDto> FindMissionByStatus(Long userId, int limit, int offset) {
        return jpaQueryFactory
            .select(Projections.constructor(
            MissionStatusDto.class,
            mission.id,
            mission.reward,
            memberMission.status,
            mission.content
        ))
            .from(mission)
            .join(memberMission)
            .on(mission.id.eq(memberMission.mission.id))
            .where(
                memberMission.member.id.eq(userId)
                    .and(memberMission.status.in(Status.ING,Status.COMPLETE))
            )
            .orderBy(memberMission.status.asc(), mission.id.asc())
            .limit(limit)
            .offset(offset)
            .fetch();
    }

    @Override
    public List<MissionRegoinDTO> findMissionByRegoin(Long userId,String addressName, int limit, int offset) {
        return jpaQueryFactory
            .select(Projections.constructor(MissionRegoinDTO.class,
                mission.id,
                mission.lowerPrice,
                mission.reward,
                mission.endTime,
                store.name.as("storeName")
            ))
            .from(mission)
            .join(mission.store, store)
            .join(mission.memberMissions, memberMission) // memberMissions 컬렉션과 JOIN
            .where(memberMission.member.id.eq(userId)  // 특정 회원의 미션
                .and(memberMission.status.eq(Status.NOCOMPLETE))  // 상태 필터링
                .and(store.address.eq(addressName)))
            .orderBy(mission.id.asc())
            .limit(10)
            .fetch();
    }




}
