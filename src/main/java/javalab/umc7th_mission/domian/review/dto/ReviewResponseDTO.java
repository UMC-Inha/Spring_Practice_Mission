package javalab.umc7th_mission.domian.review.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewResponseDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class addReview {
        Long reviewId;
        LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReviewInfo {
        String storeName;
        Double score;
        String content;
        LocalDateTime createAt;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class getAllMyReview {
        Long memberId;
        String memberName;
        List<ReviewInfo> reviewInfoList;
    }
}