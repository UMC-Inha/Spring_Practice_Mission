package javalab.umc7th_mission.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.domain.QReview;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import static ext.javalab.umc7th_mission.domain.QMember.member;
import static ext.javalab.umc7th_mission.domain.QStore.store;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QReview review = QReview.review;

    @Override
    public void saveReview(String memberName, String storeName, String text, float score){
        Member foundMember = jpaQueryFactory.selectFrom(member)
                .where(member.name.eq(memberName))
                .fetchOne();

        Store foundStore = jpaQueryFactory.selectFrom(store)
                .where(store.name.eq(storeName))
                .fetchOne();

        jpaQueryFactory.insert(review)
                .columns(review.member.name, review.store.name, review.text, review.score)
                .values(foundMember.getName(), foundStore.getName(), text, BigDecimal.valueOf(score))
                .execute();
    }

    @Override
    public List<Review> findReviewsByStore(Long storeId) {
        return jpaQueryFactory
                .selectFrom(review)
                .where(review.store.id.eq(storeId))
                .fetch();
    }
}
