package javalab.umc7th_mission.study.web.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.study.apiPayload.ApiResponse;
import javalab.umc7th_mission.study.converter.ReviewConverter;
import javalab.umc7th_mission.study.domain.Review;
import javalab.umc7th_mission.study.service.ReviewService.ReviewCommandService;
import javalab.umc7th_mission.study.web.dto.review.ReviewRequestDTO;
import javalab.umc7th_mission.study.web.dto.review.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddReviewResultDTO> add(@RequestBody @Valid ReviewRequestDTO.AddReviewDto request){
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }
}
