package javalab.umc7th_mission.web.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.ReviewConverter;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.service.ReviewService.ReviewCommandService;
import javalab.umc7th_mission.web.dto.review.ReviewRequestDTO;
import javalab.umc7th_mission.web.dto.review.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/review")
    public ApiResponse<ReviewResponseDTO.SaveResultDTO> save(@RequestBody @Valid ReviewRequestDTO.SaveDTO request) {
        Review review = reviewCommandService.save(request);
        return ApiResponse.onSuccess(ReviewConverter.toSaveResultDTO(review));
    }
}
