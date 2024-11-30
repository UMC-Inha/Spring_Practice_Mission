package javalab.umc7th_mission.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import javalab.umc7th_mission.study.apiPayload.ApiResponse;
import javalab.umc7th_mission.study.converter.ReviewConverter;
import javalab.umc7th_mission.study.domain.Review;
import javalab.umc7th_mission.study.service.ReviewService.ReviewCommandService;
import javalab.umc7th_mission.study.validation.annotation.CheckPage;
import javalab.umc7th_mission.study.validation.annotation.ExistRestaurant;
import javalab.umc7th_mission.study.web.dto.review.ReviewRequestDTO;
import javalab.umc7th_mission.study.web.dto.review.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의  리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name="storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistRestaurant @PathVariable(name="storeId") Long storeId, @CheckPage @RequestParam(name="page") Integer page){
        Page<Review> reviewList = reviewCommandService.getRestaurantReviewList(storeId, page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewList));
    }
}