package javalab.umc7th_mission.study.repository.ReviewRepository;

import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
    @Transactional
    @Query(value = "INSERT INTO Review(restaurant_id, member_id, score, content) VALUES (:restaurant_id, :member_id, :score, :content)", nativeQuery = true)
    void insertReview(@Param("restaurant_id") Long restaurant_Id, @Param("member_id") Long member_id, @Param("score") Integer score, @Param("content") String content);

    Page<Review> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);
    Page<Review> findAllByMember(Member member, PageRequest pageRequest);
}
