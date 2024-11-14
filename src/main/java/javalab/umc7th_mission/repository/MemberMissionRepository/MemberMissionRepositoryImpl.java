package javalab.umc7th_mission.repository.MemberMissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.domain.mapping.QMemberMission;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;
import static ext.javalab.umc7th_mission.domain.QRegion.region;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<MemberMission> findChallengingByMember(Long memberId, String regionName, Pageable pageable) {
        return jpaQueryFactory
                .selectFrom(memberMission)
                .where(memberMission.member.id.eq(memberId)
                        .and(region.name.eq(regionName))
                        .and(memberMission.status.eq(MissionStatus.valueOf("CHALLENGING"))))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public List<MemberMission> findCompleteByMember(Long memberId, String regionName, Pageable pageable) {
        return jpaQueryFactory
                .selectFrom(memberMission)
                .where(memberMission.member.id.eq(memberId)
                        .and(region.name.eq(regionName))
                        .and(memberMission.status.eq(MissionStatus.valueOf("COMPLETE"))))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Long countCompleteByMember(Long memberId, String regionName) {
        return jpaQueryFactory
                .select(memberMission.count())
                .from(memberMission)
                .where(memberMission.member.id.eq(memberId)
                        .and(region.name.eq(regionName))
                        .and(memberMission.status.eq(MissionStatus.valueOf("COMPLETE"))))
                .fetchOne();
    }
}
