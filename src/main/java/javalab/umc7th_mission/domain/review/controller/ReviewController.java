package javalab.umc7th_mission.domain.review.controller;

import javalab.umc7th_mission.config.apipayload.ApiResponse;
import javalab.umc7th_mission.domain.review.dto.ReviewResponse.ReviewsDTO;
import javalab.umc7th_mission.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    private static final Integer PAGE_SIZE = 10;

    @GetMapping("/member")
    public ApiResponse<ReviewsDTO> getReviewsByMember(
            Long memberId, // 로그인 되어있다고 가정
            @RequestParam(defaultValue = "0") int page
    ) {
        memberId = 0L; // 추후 argumentResolver 이용
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        ReviewsDTO result = reviewService.getReviewsByMember(memberId, pageable);
        return ApiResponse.onSuccess(result);
    }
}
