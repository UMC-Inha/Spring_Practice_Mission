package javalab.umc7th_mission.domian.store.service;

import javalab.umc7th_mission.apipayload.ApiResponse;
import javalab.umc7th_mission.domian.store.Store;
import javalab.umc7th_mission.domian.store.dto.StoreRequest;
import javalab.umc7th_mission.domian.store.dto.StoreResponse;

public interface StoreService {
    public StoreResponse.CreateByRegionDTO addStoreToRegion(StoreRequest.JoinDTO joinDTO);

    public StoreResponse.CreateReviewToStore addReview(StoreRequest.AddReviewDTO addReviewDTO);

    public StoreResponse.CreateMissionToStore addMission(StoreRequest.AddMissionDTO addMissionDTO);
}
