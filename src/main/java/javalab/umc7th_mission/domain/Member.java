package javalab.umc7th_mission.domain;

import jakarta.persistence.*;
import javalab.umc7th_mission.domain.common.BaseEntity;
import javalab.umc7th_mission.domain.enums.Gender;
import javalab.umc7th_mission.domain.mapping.MemberAgree;
import javalab.umc7th_mission.domain.mapping.MemberAlarm;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.domain.mapping.MemberPrefer;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Column(nullable = false, columnDefinition = "INTEGER CHECK (birth >= 1900 AND birth <= 2024)")
    private Integer birth;

    @Column(nullable = false, length = 40)
    private String address;

    private LocalDate inactiveDate;

    @Column(nullable = false, length = 50)
    private String email;

    private Integer point;

    private Long phoneNumber;

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAlarm> memberAlarmList = new ArrayList<>();
}
