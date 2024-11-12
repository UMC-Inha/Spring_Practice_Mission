package javalab.umc7th_mission.repository.member;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import study.domian.member.dto.ResponseDto.MemberDto;

public class MemberCustomRepositoryImpl implements memberCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public MemberDto findByMemberId(Long id) {

        return jpaQueryFactory
            .select(Projections.constructor(MemberDto.class,
                member.name,
                member.email,
                member.phoneNumber,
                member.pointValue))
            .from(member)
            .where(member.id.eq(id))
            .fetchOne();
    }
}
