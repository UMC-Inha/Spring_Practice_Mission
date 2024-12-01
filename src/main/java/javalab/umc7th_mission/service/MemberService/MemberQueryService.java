package javalab.umc7th_mission.service.MemberService;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import org.springframework.data.domain.Page;

public interface MemberQueryService {
    Member findMember(Long memberId);

    Page<Review> getReviewList(Long memberId, Integer page);
}
