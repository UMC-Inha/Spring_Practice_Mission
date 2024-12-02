package javalab.umc7th_mission.repository;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    Page<Review> findAllByMember(Member member, Pageable pageable);
}
