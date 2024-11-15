package study.domian.mission;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import lombok.*;

import study.domian.common.BaseEntity;
import study.domian.mapping.MemberMission;
import study.domian.store.Store;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Mission extends BaseEntity {
/*
`id`	bigint	NOT NULL,
	`state`	enum	NULL,
	`content`	varchar(30)	NULL,
	`price`	bigint	NULL,
	`point`	bigint	NULL,
	`endtime`	datetime	NULL,
	`authcode`	varchar(20)	NULL
);

 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false ,columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private Integer lowerPrice;

    @Column(nullable = false)
    private Integer reward;

    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY)
    private List<MemberMission> memberMissions = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;
}
