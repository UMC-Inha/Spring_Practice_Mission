package javalab.umc7th_mission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.MemberConverter;
import javalab.umc7th_mission.converter.MemberMissionConverter;
import javalab.umc7th_mission.converter.ReviewConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.service.MemberCommandService.MemberCommandService;
import javalab.umc7th_mission.service.ReviewCommandService.ReviewCommandService;
import javalab.umc7th_mission.service.ReviewQueryService.ReviewQueryService;
import javalab.umc7th_mission.validation.annotation.ExistMember;
import javalab.umc7th_mission.validation.annotation.PositivePage;
import javalab.umc7th_mission.web.dto.MemberMissionResponseDTO;
import javalab.umc7th_mission.web.dto.MemberRequestDTO;
import javalab.umc7th_mission.web.dto.MemberResponseDTO;
import javalab.umc7th_mission.web.dto.ReviewResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated //안넣으면 인지를 못함 -> 400 BadRequest
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }


    //원래 리뷰 컨트롤러에 넣을려했는데, /reviews/{memberId}/reviews? 뭔가 이상해서 옮김
    @GetMapping("{memberId}/reviews")
    @Operation(summary = "특정 멤버의 리뷰 목록 조회 API", description = "특정 멤버의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. " +
            "Query String으로 Page 번호를 주세요!")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getReviewList(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @RequestParam(name = "page") @PositivePage Integer page) {
        Integer adjustedPage = page - 1;
        Page<Review> reviewList = reviewQueryService.getMemberReviews(memberId, adjustedPage);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewList));
    }
}