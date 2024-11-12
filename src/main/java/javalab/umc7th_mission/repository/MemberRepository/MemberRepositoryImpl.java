package javalab.umc7th_mission.repository.MemberRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.domain.QMember;
import javalab.umc7th_mission.web.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public MemberDto findMemberDtoById(Long id) {
        return jpaQueryFactory
                .select(Projections.constructor(
                        MemberDto.class,
                        member.name,
                        member.email,
                        member.point)
                )
                .from(member)
                .where(member.id.eq(id))
                .fetchOne();
    }
}
