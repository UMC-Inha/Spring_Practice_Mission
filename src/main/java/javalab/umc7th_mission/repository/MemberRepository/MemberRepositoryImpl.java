package javalab.umc7th_mission.repository.MemberRepository;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.domain.QMember;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.web.dto.MemberInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    //멤버의 정보를 Dto객체로 보여주는 QueryDSL
    @Override
    public MemberInfoDto findMemberInfoById(Long memberId) {
        QMember member = QMember.member;

        return queryFactory
                .select(Projections.constructor(MemberInfoDto.class,
                        member.nickname,
                        member.email,
                        member.phoneNumber,
                        member.point))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}