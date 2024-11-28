package javalab.umc7th_mission.domian.store.controller;


import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import javalab.umc7th_mission.apipayload.ApiResponse;
import javalab.umc7th_mission.domian.store.dto.StoreRequest;
import javalab.umc7th_mission.domian.store.dto.StoreResponse;
import javalab.umc7th_mission.domian.store.dto.StoreResponse.CreateByRegionDTO;
import javalab.umc7th_mission.domian.store.dto.StoreResponse.CreateMissionToStore;
import javalab.umc7th_mission.domian.store.dto.StoreResponse.CreateReviewToStore;
import javalab.umc7th_mission.domian.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Store")
@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/create")
    public ApiResponse<CreateByRegionDTO> cerateStore(StoreRequest.JoinDTO joinDTO){

        CreateByRegionDTO createByRegionDTO = storeService.addStoreToRegion(joinDTO);

        return ApiResponse.onSuccess(createByRegionDTO);
    }

    @PostMapping("/review")
    public ApiResponse<CreateReviewToStore> createReview(StoreRequest.AddReviewDTO addReviewDTO){

        CreateReviewToStore createReviewToStore = storeService.addReview(addReviewDTO);
        return ApiResponse.onSuccess(createReviewToStore);

    }

    @PostMapping("/mission")
    public ApiResponse<CreateMissionToStore> createMission(StoreRequest.AddMissionDTO addMissionDTO){

        CreateMissionToStore createMissionToStore = storeService.addMission(addMissionDTO);
        return ApiResponse.onSuccess(createMissionToStore);

    }

}
