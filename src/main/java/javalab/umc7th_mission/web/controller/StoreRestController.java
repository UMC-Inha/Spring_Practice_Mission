package javalab.umc7th_mission.web.controller;

import jakarta.validation.Valid;
import javalab.umc7th_mission.apiPayload.ApiResponse;
import javalab.umc7th_mission.converter.MemberConverter;
import javalab.umc7th_mission.converter.StoreConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.service.StoreService.StoreCommandService;
import javalab.umc7th_mission.web.dto.member.MemberRequestDTO;
import javalab.umc7th_mission.web.dto.member.MemberResponseDTO;
import javalab.umc7th_mission.web.dto.store.StoreRequestDTO;
import javalab.umc7th_mission.web.dto.store.StoreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreRestController {
    private final StoreCommandService storeCommandService;


    @PostMapping("/store")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> join(@RequestBody @Valid StoreRequestDTO.JoinDTO request) {
        Store store = storeCommandService.join(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }


}
