package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Review;
import umc.study.repository.ReviewRepository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 트랜잭션 추가
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> findReviewByMemberIdAndStoreId(Long storeId, Long memberId) {
        return reviewRepository.dynamicQueryWithBooleanBuilder(memberId, storeId);
    }
}
