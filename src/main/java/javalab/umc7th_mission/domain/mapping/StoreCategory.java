package javalab.umc7th_mission.domain.mapping;

import jakarta.persistence.*;
import javalab.umc7th_mission.domain.FoodCategory;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.domain.common.BaseEntity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class StoreCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodCategory", referencedColumnName = "id")
    private FoodCategory foodCategory;
}
