package umc.study.repository.ReviewRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Review;

import java.util.List;

import static umc.study.domain.QReview.review;
import static umc.study.domain.QMember.member;
import static umc.study.domain.QStore.store;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;
    @Override
    public List<Review> dynamicQueryWithBooleanBuilder(Long memberId, Long storeId) {
        entityManager.clear();  // 1차 캐시 비우기
        BooleanBuilder predicate = new BooleanBuilder();

        if (memberId != null) {
            predicate.and(review.memberId.id.eq(memberId));
        }
        if (storeId != null) {
            predicate.and(review.storeId.id.eq(storeId));
        }

        return jpaQueryFactory
                .selectFrom(review)
                .join(review.memberId, member).fetchJoin()
                .join(review.storeId, store).fetchJoin()
                .leftJoin(review.reviewImageList).fetchJoin() // reviewImageList를 fetchJoin으로 로딩
                .where(predicate)
                .orderBy(review.createdAt.desc())
                .fetch();

    }

}
