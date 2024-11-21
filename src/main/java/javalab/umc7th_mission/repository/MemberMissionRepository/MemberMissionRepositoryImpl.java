package javalab.umc7th_mission.repository.MemberMissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.domain.QMember;
import ext.javalab.umc7th_mission.domain.QMission;
import ext.javalab.umc7th_mission.domain.QRegion;
import ext.javalab.umc7th_mission.domain.QStore;
import ext.javalab.umc7th_mission.domain.mapping.QMemberAddress;
import ext.javalab.umc7th_mission.domain.mapping.QMemberMission;
import ext.javalab.umc7th_mission.domain.mapping.QStoreAddress;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    //멤버 id를 통해 현재 진행중인 미션을 보여주는 QueryDSL
    @Override
    public List<MemberMission> findChallengingMissionByMember(Long memberId, Pageable pageable) {
        QMemberMission memberMission = QMemberMission.memberMission;

        return queryFactory
                .selectFrom(memberMission)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.CHALLENGING)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    //멤버 id를 통해 완료된 미션을 보여주는 QueryDSL
    @Override
    public List<MemberMission> findCompletedMissionByMember(Long memberId, Pageable pageable) {
        QMemberMission memberMission = QMemberMission.memberMission;

        return queryFactory
                .selectFrom(memberMission)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.COMPLETE)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }


    //해당 지역의 완료된 미션의 개수를 보여주는 QueryDSL
    @Override
    public Long countCompletedMissionByMember(Long memberId, String regionName) {
        QMemberMission memberMission = QMemberMission.memberMission;
        QStoreAddress storeAddress = QStoreAddress.storeAddress;
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QRegion region = QRegion.region;

        Long regionId = queryFactory
                .select(region.id)
                .from(region)
                .where(region.name.eq(regionName))
                .fetchOne();

        if (regionId == null) {
            return Long.valueOf(0);
        }

        return queryFactory
                .select(memberMission.count())
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.store, store)
                .join(storeAddress, storeAddress)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.COMPLETE),
                        storeAddress.region.id.eq(regionId)
                )
                .fetchOne();

    }
}
