package javalab.umc7th_mission.repository.MemberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.domain.QMember;
import javalab.umc7th_mission.repository.MemberMissionRepository.MemberMissionRepositoryCustom;
import javalab.umc7th_mission.web.dto.MyPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private QMember member = QMember.member;


    @Override
    public List<MyPageDto> findMemberSpecByMemberId(Long id) {
        return queryFactory
                .select(
                        Projections.constructor(
                                MyPageDto.class,
                                member.name,
                                member.email,
                                member.phoneNum
                        )
                )
                .from(member)
                .where(
                        member.id.eq(id)
                )
                .fetch();
    }
}
