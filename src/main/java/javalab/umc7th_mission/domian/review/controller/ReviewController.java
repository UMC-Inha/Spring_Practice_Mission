package javalab.umc7th_mission.domian.review.controller;


import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import javalab.umc7th_mission.apipayload.ApiResponse;
import javalab.umc7th_mission.domian.member.Member;
import javalab.umc7th_mission.domian.member.service.MemberService;
import javalab.umc7th_mission.domian.review.Review;
import javalab.umc7th_mission.domian.review.dto.ReviewConverter;
import javalab.umc7th_mission.domian.review.dto.ReviewRequestDTO;
import javalab.umc7th_mission.domian.review.dto.ReviewResponseDTO;
import javalab.umc7th_mission.domian.review.service.ReviewService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewConverter reviewConverter;
    private final MemberService memberService;

    @PostMapping("/add/{restaurantId}")
    public ApiResponse<ReviewResponseDTO.addReview> addReview(@PathVariable("restaurantId") Long restaurantId,
        @RequestBody @Valid ReviewRequestDTO.AddReview request) {
        Review review = reviewService.addReview(restaurantId, request);
        ReviewResponseDTO.addReview addReviewResponse = reviewConverter.toAddReviewResponse(review);

        return ApiResponse.onSuccess(addReviewResponse);
    }

    @GetMapping("/all/{memberId}")
    public ApiResponse<ReviewResponseDTO.getAllMyReview> getAllMyreview(@PathVariable(name = "memberId") Long memberId,
        @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
        @Parameter(hidden = true) Pageable pageable) {

        Page<Review> myReview = reviewService.getMyReview(memberId, pageable);
        Member member = memberService.findMember(memberId);
        ReviewResponseDTO.getAllMyReview allMyReview = reviewConverter.toAllMyReview(myReview, member);

        return ApiResponse.onSuccess(allMyReview);
    }
}
