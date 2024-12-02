package javalab.umc7th_mission.service.ReviewQueryService;

import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.repository.ReviewRepository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getMemberReviews(Long memberId, Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("createdAt").descending());
        Page<Review> reviewPage = reviewRepository.findByMemberId(memberId, pageRequest);
        return reviewPage;
    }
}
