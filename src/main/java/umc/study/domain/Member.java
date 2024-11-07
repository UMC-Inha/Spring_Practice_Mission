package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.SocialType;
import umc.study.domain.mapping.MemberAgree;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MemberPrefer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private LocalDateTime birth;
    private Long foodCategory;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    // @Builder 어노테이션과 명시적 생성자 사용
    @Builder
    public Member(Gender gender, SocialType socialType, String name, LocalDateTime birth, Long foodCategory,
                  String email, String phoneNumber, List<Review> reviewList, List<MemberMission> memberMissionList,
                  List<MemberPrefer> memberPreferList, List<MemberAgree> memberAgreeList) {
        this.gender = gender;
        this.socialType = socialType;
        this.name = name;
        this.birth = birth;
        this.foodCategory = foodCategory;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.reviewList = reviewList != null ? reviewList : new ArrayList<>();
        this.memberMissionList = memberMissionList != null ? memberMissionList : new ArrayList<>();
        this.memberPreferList = memberPreferList != null ? memberPreferList : new ArrayList<>();
        this.memberAgreeList = memberAgreeList != null ? memberAgreeList : new ArrayList<>();
    }
}
