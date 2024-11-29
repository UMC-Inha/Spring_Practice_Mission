package javalab.umc7th_mission.domain.review.repository;

import javalab.umc7th_mission.domain.review.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findByMemberId(Long memberId, Pageable pageable);

}
