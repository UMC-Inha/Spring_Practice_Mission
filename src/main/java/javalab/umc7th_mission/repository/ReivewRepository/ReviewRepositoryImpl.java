package javalab.umc7th_mission.repository.ReivewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.domain.QReview;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QReview review = QReview.review;

    @Override
    public Long save(Member member, Store store, String body, String score) {
        return queryFactory
                .insert(review)
                .columns(review.member, review.store, review.body, review.score)
                .values(member, store, body, score)
                .execute();
    }
}
