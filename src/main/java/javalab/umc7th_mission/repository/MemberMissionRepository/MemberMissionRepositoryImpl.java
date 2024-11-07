package javalab.umc7th_mission.repository.MemberMissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.domain.mapping.QMemberMission;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.web.dto.HomePageDto;
import javalab.umc7th_mission.web.dto.MissionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    @Override
    public List<MissionDto> findMissionsByMemberIdAndStatus(Long memberId, Pageable pageable) {
        return queryFactory
                .select(
                        Projections.constructor(
                                MissionDto.class,
                                memberMission.mission.reward,
                                memberMission.mission.deadline,
                                memberMission.mission.missionSpec
                        )
                )
                .from(memberMission)
                .where(
                        memberMission.member.id.eq(memberId)
                                .and(memberMission.status.in(MissionStatus.IN_PROGRESS, MissionStatus.DONE))
                )
                .offset(pageable.getOffset())
                .limit(100)
                .fetch();
    }

    @Override
    public List<HomePageDto> findMissionByMemberIdAndRegion(Long memberId, String regionName, Pageable pageable) {
        return queryFactory
                .select(
                        Projections.constructor(
                                HomePageDto.class,
                                memberMission.mission.store.name,
                                memberMission.mission.missionSpec,
                                memberMission.mission.deadline
                        )
                )
                .from(memberMission)
                .where(
                        memberMission.member.id.eq(memberId)
                                .and(memberMission.status.eq(MissionStatus.NOT_STARTED))
                                .and(memberMission.mission.store.region.name.eq(regionName))
                                .and(memberMission.mission.deadline.gt(LocalDateTime.now()))
                )
                .orderBy(memberMission.mission.deadline.asc())
                .offset(pageable.getOffset())
                .limit(100)
                .fetch();
    }
}
