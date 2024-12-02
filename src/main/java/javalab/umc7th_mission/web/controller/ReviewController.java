package javalab.umc7th_mission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import javalab.global.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.ReviewConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.service.MemberService;
import javalab.umc7th_mission.service.ReviewService;
import javalab.umc7th_mission.web.dto.request.ReviewRequestDTO;
import javalab.umc7th_mission.web.dto.response.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewConverter reviewConverter;
    private final MemberService memberService;

    @PostMapping("/add/{restaurantId}")
    public ApiResponse<ReviewResponseDTO.addReview> addReview(@PathVariable ("restaurantId") Long restaurantId,
                                                              @RequestBody @Valid ReviewRequestDTO.AddReview request) {
        Review review = reviewService.addReview(restaurantId, request);
        ReviewResponseDTO.addReview addReviewResponse = reviewConverter.toAddReviewResponse(review);

        return ApiResponse.onSuccess(addReviewResponse);
    }

    @GetMapping("/all/{memberId}")
    @Operation(summary = "내가 작성한 리뷰 목록", description = "내가 작성한 리뷰 목록을 조회하는 API입니다.")
    @Parameter(name = "memberId", description = "조회할 회원의 id를 입력해 주세요.")
    public ApiResponse<ReviewResponseDTO.getAllMyReview> getAllMyreview(@PathVariable(name = "memberId") Long memberId,
                                                                        @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC)
                                                                        @Parameter(hidden = true) Pageable pageable) {

        Page<Review> myReview = reviewService.getMyReview(memberId, pageable);
        Member member = memberService.findMember(memberId);
        ReviewResponseDTO.getAllMyReview allMyReview = reviewConverter.toAllMyReview(myReview, member);

        return ApiResponse.onSuccess(allMyReview);
    }
}
