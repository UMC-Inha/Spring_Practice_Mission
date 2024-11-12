package javalab.umc7th_mission.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import  javalab.umc7th_mission.study.domain.Member;
import  javalab.umc7th_mission.study.domain.Term;
import  javalab.umc7th_mission.study.domain.common.BaseEntity;
import  javalab.umc7th_mission.study.domain.enums.TermAgree;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberTerm extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private TermAgree agree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id")
    private Term term;



}
