package javalab.umc7th_mission.domain.foodcategory;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import javalab.umc7th_mission.domain.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "food_category_id")
    private Long id;

    @Column(nullable = false, unique = true, length = 15)
    private String name;

    @Builder
    public FoodCategory(String name) {
        this.name = name;
    }

}
