package javalab.umc7th_mission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.StoreConverter;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.service.StoreQueryService.StoreQueryService;
import javalab.umc7th_mission.service.StoreCommandService.StoreCommandService;
import javalab.umc7th_mission.validation.annotation.ExistStore;
import javalab.umc7th_mission.web.dto.StoreRequestDTO;
import javalab.umc7th_mission.web.dto.StoreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.AddResultDTO> join(@RequestBody @Valid StoreRequestDTO.AddDto request){

        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddResultDTO(store));
    }

    @GetMapping("{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. " +
            "Query String으로 Page 번호를 주세요!")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),

    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        //페이지 번호가 0번부터 오지 않고 1번부터 시작이라 변경함 Swagger 정상작동 확인
        Integer adjustedPage = page - 1;
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, adjustedPage);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }
}