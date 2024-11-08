package javalab.umc7th_mission.domain;

import jakarta.persistence.*;
import javalab.global.entity.BaseEntity;
import javalab.umc7th_mission.domain.photo.ReviewPhoto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String content;

    @Column(nullable = false)
    private Double score;

    @OneToMany(mappedBy = "review")
    private List<ReviewPhoto> photoList = new ArrayList<>();

}
