package study.domian.member;


import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.domian.common.BaseEntity;
import study.domian.mapping.MemberCategory;
import study.domian.mapping.MemberMission;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Member extends BaseEntity {
    /*
        `id`bigint	NOT NULL,
        `region_id`	bigint	NOT NULL,
        `email`	VARCHAR(30)	NULL,
        `name`	varchar(20)	NULL,
        `gender`	enum	NULL	COMMENT 'MALE, FEMALE',
        `point_value`	int	NULL,
        `birth_day`	date	NULL,
        `address`	varchar(20)	NULL,
        `phone_number`	bigint	NULL
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String email;

    private String name;

    private Gender gender;

    private Integer pointValue;

    private String birthDay;

    private String address;

    private Integer phoneNumber;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MemberCategory> memberCategorys = new ArrayList<>();
}