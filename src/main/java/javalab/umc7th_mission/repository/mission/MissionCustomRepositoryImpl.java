package javalab.umc7th_mission.repository.mission;


import static study.domian.mapping.QMemberMission.memberMission;
import static study.domian.mission.QMission.mission;
import static study.domian.store.QStore.store;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.domian.mission.dto.MissionRequest.MissionRegoinDTO;
import study.domian.mission.dto.MissionRequest.MissionStatusDto;

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
                    .and(memberMission.status.in(1, 2)) // state가 1 또는 2인 경우 필터링
            )
            .orderBy(memberMission.status.asc(), mission.id.asc())
            .limit(limit)
            .offset(offset)
            .fetch();
    }

    @Override
    public List<MissionRegoinDTO> findMissionByRegoin(Long userId, int limit, int offset) {
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
            .where(mission.status.eq("possible")
                .and(store.address.eq(address)))
            .orderBy(mission.id.asc())
            .limit(10)
            .fetch();
    }




}
