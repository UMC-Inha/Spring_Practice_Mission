package umc.study.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Member;

import static umc.study.domain.QMember.member;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Member findMemberDetailsById(Long userId) {
        return jpaQueryFactory
                .selectFrom(member)
                .where(member.id.eq(userId))
                .fetchOne();
    }
}