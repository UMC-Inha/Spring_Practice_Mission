package javalab.umc7th_mission.repository.ReviewRepository;

import jakarta.transaction.Transactional;
import javalab.umc7th_mission.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

//24.11.19 @Repository add
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Review (member_id, store_id, content, rating) VALUES (:memberId, :storeId, :content, :rating)", nativeQuery = true)
    void insertReview(@Param("memberId") Long memberId,
                      @Param("storeId") Long storeId,
                      @Param("content") String content,
                      @Param("rating") BigDecimal rating
                      );
}