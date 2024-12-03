package javalab.umc7th_mission.domian.review.repository;

import javalab.umc7th_mission.domian.member.Member;
import javalab.umc7th_mission.domian.review.Review;
import javalab.umc7th_mission.domian.store.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByMember(Member member, Pageable pageable);
}
