package javalab.umc7th_mission.service.ReviewService;

import javalab.umc7th_mission.converter.ReviewConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.repository.ReivewRepository.ReviewRepository;
import javalab.umc7th_mission.service.MemberService.MemberQueryService;
import javalab.umc7th_mission.service.StoreService.StoreQueryService;
import javalab.umc7th_mission.web.dto.review.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberQueryService memberQueryService;
    private final StoreQueryService storeQueryService;

    @Override
    public Review save(ReviewRequestDTO.SaveDTO request) {
        Review newReview = ReviewConverter.toReview(request);
        Member member = memberQueryService.findMember(request.getMemberId());
        Store store = storeQueryService.findStore(request.getStoreId());
        newReview.setMember(member);
        newReview.setStore(store);
        return reviewRepository.save(newReview);
    }

}
