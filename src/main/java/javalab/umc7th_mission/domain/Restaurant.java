package javalab.umc7th_mission.domain;


import jakarta.persistence.*;
import javalab.global.entity.BaseEntity;
import javalab.umc7th_mission.domain.mapping.RestaurantCategory;
import javalab.umc7th_mission.domain.photo.RestaurantPhoto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {

    @Id
    @Column(name = "restaurant_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String type;

    @Column(length = 50)
    private String address;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @Builder.Default
    private List<RestaurantPhoto> photoList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @Builder.Default
    private List<RestaurantCategory> categoryList = new ArrayList<>();
}
