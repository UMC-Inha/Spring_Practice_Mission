package javalab.umc7th_mission.domain.photo;

import jakarta.persistence.*;
import javalab.global.entity.BaseEntity;
import javalab.umc7th_mission.domain.Review;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewPhoto extends BaseEntity {

    @Id
    @Column(name = "review_photo_id")
    private Long id;

    @Column(nullable = false)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

}
