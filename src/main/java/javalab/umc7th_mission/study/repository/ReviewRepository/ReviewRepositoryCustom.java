package javalab.umc7th_mission.study.repository.ReviewRepository;

import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.domain.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ReviewRepositoryCustom {
    public Long save(Member member, Restaurant restaurant, Integer score, String content);
}
