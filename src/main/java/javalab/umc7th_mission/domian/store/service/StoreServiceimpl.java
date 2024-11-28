package javalab.umc7th_mission.domian.store.service;

import java.util.List;
import java.util.Optional;
import javalab.umc7th_mission.apipayload.code.status.ErrorStatus;
import javalab.umc7th_mission.apipayload.exception.GeneralException;
import javalab.umc7th_mission.domian.mission.Mission;
import javalab.umc7th_mission.domian.mission.repository.MissionRepository;
import javalab.umc7th_mission.domian.region.Region;
import javalab.umc7th_mission.domian.region.repository.RegionRepository;
import javalab.umc7th_mission.domian.review.Review;
import javalab.umc7th_mission.domian.review.repository.ReviewRepository;
import javalab.umc7th_mission.domian.store.Store;
import javalab.umc7th_mission.domian.store.dto.StoreConverter;
import javalab.umc7th_mission.domian.store.dto.StoreRequest;
import javalab.umc7th_mission.domian.store.dto.StoreResponse;
import javalab.umc7th_mission.domian.store.dto.StoreResponse.CreateByRegionDTO;
import javalab.umc7th_mission.domian.store.dto.StoreResponse.CreateMissionToStore;
import javalab.umc7th_mission.domian.store.dto.StoreResponse.CreateReviewToStore;
import javalab.umc7th_mission.domian.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreServiceimpl implements StoreService {

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public CreateByRegionDTO addStoreToRegion(StoreRequest.JoinDTO joinDTO) {
        // 특정 지역을 데이터베이스에서 조회
        Region region = regionRepository.findById(joinDTO.getRegionId())
            .orElseThrow(() -> new IllegalArgumentException("Invalid region ID: " + joinDTO.getRegionId()));

        // 새로운 Store 객체 생성
        Store store = StoreConverter.StoreByRegion(region, joinDTO);

        // Store 저장
        storeRepository.save(store);

        return CreateByRegionDTO.builder()
            .inSuccess("ok")
            .build();
    }


    @Override
    public CreateReviewToStore addReview(StoreRequest.AddReviewDTO addReviewDTO) {
        Store store = storeRepository.findById(addReviewDTO.getStoreId())
            .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));//todo errorstatus 추가

        Review review = Review.builder()
            .title(addReviewDTO.getTitle())
            .body(addReviewDTO.getBody())
            .score(addReviewDTO.getScore())
            .build();

        review.setStore(store);
        reviewRepository.save(review);
        List<Review> reviewList = store.getReviewList();
        reviewList.add(review);

        return CreateReviewToStore.builder()
            .inSuccess("ok")
            .build();
    }


    @Override
    public CreateMissionToStore addMission(StoreRequest.AddMissionDTO addMissionDTO){
        Store store = storeRepository.findById(addMissionDTO.getStoreId())
            .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));

        Mission mission= Mission.builder()
            .reward(addMissionDTO.getReward())
            .missionSpec(addMissionDTO.getMissionSpec())
            .deadline(addMissionDTO.getDeadline())
            .store(store)
            .build();

        missionRepository.save(mission);
        List<Mission> missionList = store.getMissionList();
        missionList.add(mission);

        return CreateMissionToStore.builder()
            .inSuccess("ok")
            .build();
    }
}
