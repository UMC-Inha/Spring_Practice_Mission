package javalab.umc7th_mission.domain;
import jakarta.persistence.*;
import javalab.umc7th_mission.domain.common.BaseEntity;
import javalab.umc7th_mission.domain.enums.Gender;
import javalab.umc7th_mission.domain.enums.MemberStatus;
import javalab.umc7th_mission.domain.mapping.MemberAddress;
import javalab.umc7th_mission.domain.mapping.MemberAgree;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.domain.mapping.MemberPrefer;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Columns;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
//24.11.20 @Setter 추가
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    //24.11.20 point = 0 -> @ColumDefault, api에서 null문제가 꾸준히 발생하여 변경함
    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer point;

    //24.11.21 fix/#7
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private MemberAddress address;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
