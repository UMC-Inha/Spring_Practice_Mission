package javalab.umc7th_mission.domain.mapping;

import jakarta.persistence.*;
import javalab.umc7th_mission.domain.Region;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.domain.common.BaseEntity;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class StoreAddress extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;

    @OneToOne(mappedBy = "address",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Store store;

    @Column(nullable = false, length = 100)
    private String detailAddress;

    @Column(nullable = false, length = 40)
    private String zipCode;
}
