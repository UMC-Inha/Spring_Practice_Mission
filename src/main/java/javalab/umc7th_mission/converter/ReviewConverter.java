package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.web.dto.ReviewRequestDTO;
import javalab.umc7th_mission.web.dto.ReviewResponseDTO;
import javalab.umc7th_mission.web.dto.StoreResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public class ReviewConverter {

    public static ReviewResponseDTO.AddResultDTO toAddResultDTO(Review review) {
        return new ReviewResponseDTO.AddResultDTO(
                review.getId(),
                review.getCreatedAt()
        );
    }

    public static Review toReview(Member member, Store store, ReviewRequestDTO.AddDTO request) {
        return Review.builder()
                .member(member)
                .store(store)
                .content(request.getContent())
                .rating(request.getRating())
                .reviewImageList(request.getReviewImageList())
                .build();
    }

    //24.11.26 ReviewPreview 관련 컨버터 추가 (빌더 패턴 이용)
    public static ReviewResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review) {
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getNickname())
                .storeName(review.getStore().getName())
                .rating(review.getRating())
                .body(review.getContent())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO reviewPreViewListDTO(Page<Review> reviewList) {
        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreviewDTO).toList();

        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .reviewList(reviewPreviewDTOList)
                .listSize(reviewPreviewDTOList.size())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .isFirstPage(reviewList.isFirst())
                .isLastPage(reviewList.isLast())
                .build();
    }
}