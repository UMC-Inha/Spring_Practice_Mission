package javalab.umc7th_mission.study.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.study.domain.QReview;
import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.domain.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QReview review = QReview.review;

    @Override
    public Long save(Member member, Restaurant restaurant, Integer score, String content) {

        return queryFactory
                .insert(review)
                .columns(review.member, review.restaurant, review.score, review.content)
                .values(member, restaurant, score, content)
                .execute();
    }
}
