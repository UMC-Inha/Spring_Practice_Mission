package study.domian.alarm;


import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.domian.common.BaseEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Alarm extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="alarm_id")
    private Long id;


}
