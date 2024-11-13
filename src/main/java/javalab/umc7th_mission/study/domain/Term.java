package javalab.umc7th_mission.study.domain;

import jakarta.persistence.*;
import lombok.*;
import javalab.umc7th_mission.study.domain.common.BaseEntity;
import javalab.umc7th_mission.study.domain.enums.TermRequired;
import javalab.umc7th_mission.study.domain.mapping.MemberTerm;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Term extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TermRequired required;

    @OneToMany(mappedBy = "term", cascade = CascadeType.ALL)
    private List<MemberTerm> memberTermList = new ArrayList<>();
}
