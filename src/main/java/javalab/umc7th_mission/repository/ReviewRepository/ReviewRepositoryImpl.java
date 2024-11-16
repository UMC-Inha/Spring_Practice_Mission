package javalab.umc7th_mission.repository.ReviewRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.domain.QReview;
import ext.javalab.umc7th_mission.domain.QMember;
import javalab.umc7th_mission.web.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QReview review = QReview.review;
    private final QMember member = QMember.member;

    @Override
    public List<MemberDto> findMembersByStoreId(Long storeId) {
        return jpaQueryFactory
                .select(Projections.constructor(
                        MemberDto.class,
                        member.name,
                        member.email,
                        member.point)
                )
                .from(review)
                .join(review.member, member)
                .where(review.store.id.eq(storeId))
                .fetch();
    }
}