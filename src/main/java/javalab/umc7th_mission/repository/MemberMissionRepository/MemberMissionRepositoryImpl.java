package javalab.umc7th_mission.repository.MemberMissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.domain.QMemberMission;
import ext.javalab.umc7th_mission.domain.QMission;
import javalab.umc7th_mission.web.dto.MissionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;

    @Override
    public List<MissionDto> findIncompleteMissionsByMemberId(Long memberId) {
        return jpaQueryFactory
                .select(Projections.constructor(
                        MissionDto.class,
                        mission.id,
                        mission.mission_spec,
                        mission.reward)
                )
                .from(memberMission)
                .join(memberMission.mission, mission)
                .where(memberMission.member.id.eq(memberId)
                        .and(memberMission.status.ne("COMPLETED")))
                .fetch();
    }
}