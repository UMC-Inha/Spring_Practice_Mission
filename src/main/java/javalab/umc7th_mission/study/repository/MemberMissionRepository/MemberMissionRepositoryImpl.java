package javalab.umc7th_mission.study.repository.MemberMissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.study.domain.QMission;
import ext.javalab.umc7th_mission.study.domain.QRegion;
import ext.javalab.umc7th_mission.study.domain.mapping.QMemberMission;
import javalab.umc7th_mission.study.domain.enums.MissionStatus;
import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MemberMission> challengingMemberMissions(Long memberId, Pageable pageable){
        return queryFactory
                .selectFrom(memberMission)
                .where(
                        memberMission.member.id.eq(memberId)
                                        .and(memberMission.status.in(MissionStatus.CHALLENGING, MissionStatus.COMPLETE))
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Long countCompletedMemberMissionsByMemberIdAndRegion(Long memberId, String regionName){
        QMission mission = QMission.mission;
        QRegion region = QRegion.region;

        if(regionName==null){
            return Long.valueOf(0);
        }

        return jpaQueryFactory
                .select(memberMission.count())
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.restaurant.region, region)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.COMPLETE),
                        region.name.eq(regionName)
                )
                .fetchOne();
    }

}
