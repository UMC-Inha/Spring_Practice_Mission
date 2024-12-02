package javalab.umc7th_mission.domian.review.dto;

import java.util.List;
import javalab.umc7th_mission.domian.member.Member;
import javalab.umc7th_mission.domian.review.Review;
import javalab.umc7th_mission.domian.review.dto.ReviewResponseDTO.ReviewInfo;
import javalab.umc7th_mission.domian.store.Store;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {

    public Review toEntity(ReviewRequestDTO.AddReview request, Member member, Store store) {
        return Review.builder()
            .member(member)
            .store(store)
            .score(request.getScore())
            .build();
    }

    public ReviewResponseDTO.addReview toAddReviewResponse(Review review) {
        return ReviewResponseDTO.addReview.builder()
            .reviewId(review.getId())
            .createdAt(review.getCreatedAt())
            .build();
    }

    public ReviewResponseDTO.getAllMyReview toAllMyReview(Page<Review> reviews, Member member) {
        List<ReviewInfo> list = reviews.stream().map(
                review -> ReviewResponseDTO.ReviewInfo.builder()
                    .storeName(review.getStore().getName())
                    .score(review.getScore())
                    .content(review.getBody())
                    .createAt(review.getCreatedAt())
                    .build())
            .toList();

        return ReviewResponseDTO.getAllMyReview.builder()
            .memberId(member.getId())
            .memberName(member.getName())
            .reviewInfoList(list)
            .build();
    }
}