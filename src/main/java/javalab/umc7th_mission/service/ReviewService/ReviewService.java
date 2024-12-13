package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.dto.ReviewRequestDTO;
import umc.spring.dto.ReviewResponseDTO;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public ReviewResponseDTO addReview(ReviewRequestDTO request) {
        // Store 확인
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));

        // Member 확인
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        // Review 생성
        Review review = Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .store(store)
                .member(member)
                .build();

        // Review 저장
        review = reviewRepository.save(review);

        // 응답 DTO 생성 및 반환
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .storeId(store.getId())
                .memberId(member.getId())
                .build();
    }

    // 내가 작성한 리뷰 목록 조회
    public Page<ReviewResponseDTO> getMyReviews(Long memberId, Integer page, Integer size) {
        // 페이징 처리 (PageRequest 생성)
        PageRequest pageable = PageRequest.of(page, size);

        // 리뷰 조회 및 DTO 변환
        return reviewRepository.findByMemberId(memberId, pageable)
                .map(review -> ReviewResponseDTO.builder()
                        .id(review.getId())
                        .title(review.getTitle())
                        .score(review.getScore())
                        .storeId(review.getStore().getId())
                        .memberId(review.getMember().getId())
                        .build());
    }
}
