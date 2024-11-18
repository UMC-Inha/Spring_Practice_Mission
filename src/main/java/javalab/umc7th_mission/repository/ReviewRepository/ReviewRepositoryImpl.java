package javalab.umc7th_mission.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.domain.QReview;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QReview review = QReview.review;

    //리뷰 작성 및 저장
    @Override
    public Long save(Member member, Store store, String content, BigDecimal rating) {
        return queryFactory
                .insert(review)
                .columns(review.member, review.store, review.content, review.rating)
                .values(member, store, content, rating)
                .execute();
    }
}