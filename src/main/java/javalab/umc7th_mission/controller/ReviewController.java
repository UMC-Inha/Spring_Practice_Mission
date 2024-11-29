package umc.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.spring.dto.ReviewRequestDTO;
import umc.spring.dto.ReviewResponseDTO;
import umc.spring.service.ReviewService.ReviewService;
import umc.spring.validation.annotation.PageValidation;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 추가 API
    @PostMapping
    public ResponseEntity<ReviewResponseDTO> addReview(@RequestBody ReviewRequestDTO request) {
        ReviewResponseDTO response = reviewService.addReview(request);
        return ResponseEntity.ok(response);
    }

    // 내가 작성한 리뷰 목록 조회 API
    @GetMapping("/my")
    public ResponseEntity<Page<ReviewResponseDTO>> getMyReviews(
            @RequestParam("page") @PageValidation Integer page,
            @RequestParam("size") Integer size,
            @RequestParam("memberId") Long memberId // 회원 ID를 요청 파라미터로 받음
    ) {
        Page<ReviewResponseDTO> reviews = reviewService.getMyReviews(memberId, page, size);
        return ResponseEntity.ok(reviews);
    }
}