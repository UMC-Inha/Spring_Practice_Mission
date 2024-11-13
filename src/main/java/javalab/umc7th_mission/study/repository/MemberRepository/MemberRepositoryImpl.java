package javalab.umc7th_mission.study.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.study.domain.QMember;
import javalab.umc7th_mission.study.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    private final QMember member = QMember.member;

    @Override
    public Member findMemberById(Long id) {
        return queryFactory
                .selectFrom(member)
                .where(member.id.eq(id))
                .fetchOne();
    }


}
