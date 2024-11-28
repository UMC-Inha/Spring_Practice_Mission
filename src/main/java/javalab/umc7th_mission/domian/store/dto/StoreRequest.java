package javalab.umc7th_mission.domian.store.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import javalab.umc7th_mission.domian.member.Member;
import javalab.umc7th_mission.domian.store.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreRequest {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JoinDTO{

        Long regionId;
        String storeName;
        String storeAddress;
        Float storeScore;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddReviewDTO{
        Long storeId;
        String title;
        Float score;
        String body;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddMissionDTO{
        Long storeId;
        Integer reward;
        LocalDate deadline;
        String missionSpec;
    }




}
