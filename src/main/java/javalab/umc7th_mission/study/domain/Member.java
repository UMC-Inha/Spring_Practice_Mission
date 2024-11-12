package javalab.umc7th_mission.study.domain;

import jakarta.persistence.*;
import lombok.*;
import javalab.umc7th_mission.study.domain.Review;
import javalab.umc7th_mission.study.domain.common.BaseEntity;
import javalab.umc7th_mission.study.domain.enums.MemberStatus;
import javalab.umc7th_mission.study.domain.enums.Role;
import javalab.umc7th_mission.study.domain.mapping.MemberFood;
import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import javalab.umc7th_mission.study.domain.mapping.MemberQuestion;
import javalab.umc7th_mission.study.domain.mapping.MemberTerm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false)
    private Date birth;

    @Column(nullable = true, length = 20)
    private String email;

    @Column(nullable = true, length = 15)
    private String phoneNumber;

    @Column(nullable = false)
    private Integer point;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private MemberStatus status;

    @Column(nullable = true)
    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberTerm> memberTermList = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberFood> memberFoodList = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberQuestion> memberQuestionList = new ArrayList<>();
}