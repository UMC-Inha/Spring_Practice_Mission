package javalab.umc7th_mission.domain.member.repository;


import static umc.umcjpaproject.domain.member.QMember.member;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CustomMemberRepositoryImpl implements CustomMemberRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public JPAQuery<Tuple> missionFour(Long userId) {
        return queryFactory
                .select(member.id, member.name, member.email, member.point)
                .from(member)
                .join(point).on(point.user.id.eq(user.id))
                .where(user.id.eq(userId).and(user.phoneNumber.isNotNull()))
                .orderBy(point.id.asc())
                .limit(1);
    }

}
