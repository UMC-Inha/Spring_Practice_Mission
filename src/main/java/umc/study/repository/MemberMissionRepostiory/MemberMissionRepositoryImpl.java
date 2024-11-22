package umc.study.repository.MemberMissionRepostiory;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Member;
import umc.study.domain.QMission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.QMemberMission;

import java.util.List;

import static umc.study.domain.QMission.*;
import static umc.study.domain.mapping.QMemberMission.*;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MemberMission> dynamicQueryWithBooleanBuilder(Long memberId){
        BooleanBuilder predicate = new BooleanBuilder();

        BooleanBuilder statusCondition = new BooleanBuilder();
        statusCondition.or(memberMission.status.eq(MissionStatus.PROCEEDING))
                .or(memberMission.status.eq(MissionStatus.SUCCESS));


        return jpaQueryFactory
                .selectFrom(memberMission)
                .join(memberMission.missionId, mission) // mission 테이블과의 조인 설정
                .where(
                        memberMission.memberId.id.eq(memberId) // memberId에 대한 조건 설정
                                .and(statusCondition) // 상태 조건 설정
                )
                .orderBy(memberMission.status.desc()) // status에 대한 내림차순 정렬
                .limit(10) // limit 10
                .offset(0) // offset 0
                .fetch();
    }
}
