package javalab.umc7th_mission.study.repository.MissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.study.domain.QMission;
import ext.javalab.umc7th_mission.study.domain.QRestaurant;
import ext.javalab.umc7th_mission.study.domain.mapping.QMemberMission;
import javalab.umc7th_mission.study.web.dto.AvailableMissionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QMission mission = QMission.mission;

    @Override
    public List<AvailableMissionDTO> findMissionsNotInMemberMission(Long memberId, String regionName, Pageable pageable){
        QRestaurant restaurant = QRestaurant.restaurant;
        QMemberMission memberMission = QMemberMission.memberMission;

        if(regionName == null){
            return Collections.emptyList();
        }

        return queryFactory
                .select(
                        Projections.constructor(
                        AvailableMissionDTO.class,
                        restaurant.name,
                        restaurant.type
                        )

                )
                .from(mission)
                .join(mission.restaurant, restaurant)
                .where(
                        mission.restaurant.region.name.eq(regionName),
                        mission.id.notIn(
                        JPAExpressions
                                .select(memberMission.mission.id)
                                .from(memberMission)
                                .where(memberMission.member.id.eq(memberId))
                ))
                .orderBy(mission.deadline.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}
