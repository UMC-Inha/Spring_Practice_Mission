package javalab.umc7th_mission.domain.mapping;

import jakarta.persistence.*;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Region;
import javalab.umc7th_mission.domain.common.BaseEntity;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MemberAddress extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;

    //24.11.21 fix/#7
    @OneToOne(mappedBy = "address",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Member member;

    @Column(nullable = false, length = 100)
    private String detailAddress;

    @Column(nullable = false, length = 40)
    private String zipCode;

}