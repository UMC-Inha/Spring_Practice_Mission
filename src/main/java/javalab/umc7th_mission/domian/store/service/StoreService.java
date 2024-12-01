package javalab.umc7th_mission.domian.store.service;

import java.util.List;
import java.util.Optional;
import javalab.umc7th_mission.apipayload.ApiResponse;
import javalab.umc7th_mission.domian.review.Review;
import javalab.umc7th_mission.domian.store.Store;
import javalab.umc7th_mission.domian.store.dto.StoreRequest;
import javalab.umc7th_mission.domian.store.dto.StoreResponse;
import org.springframework.data.domain.Page;

public interface StoreService {
    public StoreResponse.CreateByRegionDTO addStoreToRegion(StoreRequest.JoinDTO joinDTO);

    public StoreResponse.CreateReviewToStore addReview(StoreRequest.AddReviewDTO addReviewDTO);

    public StoreResponse.CreateMissionToStore addMission(StoreRequest.AddMissionDTO addMissionDTO);

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
