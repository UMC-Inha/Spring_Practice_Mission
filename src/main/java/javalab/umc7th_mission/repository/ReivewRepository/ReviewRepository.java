package javalab.umc7th_mission.repository.ReivewRepository;

import jakarta.transaction.Transactional;
import javalab.umc7th_mission.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
