package javalab.umc7th_mission.domain;

import jakarta.persistence.*;
import javalab.global.entity.BaseEntity;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Notification extends BaseEntity {

    @Id
    @Column(name = "notification_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private Boolean eventAgree;

    private Boolean reviewAgree;

    private Boolean qnaAgree;
}
