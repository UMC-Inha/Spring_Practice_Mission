package javalab.umc7th_mission.domain;

import jakarta.persistence.*;
import javalab.global.entity.BaseEntity;
import javalab.umc7th_mission.domain.enums.Gender;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(6)")
    private Gender gender;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate birth;

    @Column(length = 50)
    private String address;

    @Column(nullable = false)
    private Boolean location_terms;

    @Column(nullable = false)
    private Boolean marketing_terms;

    private Long point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Notification> notificationList = new ArrayList<>();
}
