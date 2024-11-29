package javalab.umc7th_mission.domain.review.service;

import java.util.ArrayList;
import java.util.List;
import javalab.umc7th_mission.domain.review.Review;
import javalab.umc7th_mission.domain.review.dto.ReviewResponse;
import javalab.umc7th_mission.domain.review.dto.ReviewResponse.ReviewDTO;
import javalab.umc7th_mission.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewResponse.ReviewsDTO getReviewsByMember(Long memberId, Pageable pageable) {
        Page<Review> reviews = reviewRepository.findByMemberId(memberId, pageable);

        List<ReviewDTO> reviewDTOs = new ArrayList<>();
        for (Review review : reviews) {
            ReviewDTO reviewDTO = new ReviewDTO(
                    review.getMember().getName(),
                    review.getScore(),
                    review.getBody(),
                    review.getCreatedAt().toLocalDate()
            );
            reviewDTOs.add(reviewDTO);
        }

        return new ReviewResponse.ReviewsDTO(reviewDTOs);

    }
}

