package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Review;
import org.springframework.data.domain.Pageable;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 회원 ID로 리뷰 조회 (페이징 포함)
    Page<Review> findByMemberId(Long memberId, Pageable pageable);
}
