package javalab.umc7th_mission.web.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.StoreConverter;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.service.StoreCommandService.StoreCommandService;
import javalab.umc7th_mission.web.dto.StoreRequestDTO;
import javalab.umc7th_mission.web.dto.StoreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.AddResultDTO> join(@RequestBody @Valid StoreRequestDTO.AddDto request){

        Store store = storeCommandService.addStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddResultDTO(store));
    }
}