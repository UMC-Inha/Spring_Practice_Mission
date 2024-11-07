package javalab.umc7th_mission.domain;
import jakarta.persistence.*;
import javalab.umc7th_mission.domain.common.BaseEntity;
import javalab.umc7th_mission.domain.mapping.MemberNotification;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Notification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String message;

    @Column(nullable = false, length = 50)
    private String type;

    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<MemberNotification> memberNotificationList = new ArrayList<>();
}
