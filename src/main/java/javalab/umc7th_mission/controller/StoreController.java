package javalab.umc7th_mission.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.dto.StoreRequestDTO;
import umc.spring.dto.StoreResponseDTO;
import umc.spring.service.StoreService.StoreService;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO> addStore(@RequestBody @Valid StoreRequestDTO request) {
        Store store = storeService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toStoreResponseDTO(store)); // 응답 DTO로 변환하여 반환
    }
}
