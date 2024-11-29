package javalab.umc7th_mission.web.controller;

import jakarta.validation.Valid;
import javalab.global.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.ReviewConverter;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.service.ReviewService;
import javalab.umc7th_mission.web.dto.request.ReviewRequestDTO;
import javalab.umc7th_mission.web.dto.response.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewConverter reviewConverter;

    @PostMapping("/add/{restaurantId}")
    public ApiResponse<ReviewResponseDTO.addReview> addReview(@PathVariable ("restaurantId") Long restaurantId,
                                                              @RequestBody @Valid ReviewRequestDTO.AddReview request) {
        Review review = reviewService.addReview(restaurantId, request);
        ReviewResponseDTO.addReview addReviewResponse = reviewConverter.toAddReviewResponse(review);

        return ApiResponse.onSuccess(addReviewResponse);
    }
}
