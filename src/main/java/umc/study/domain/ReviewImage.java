package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA가 통신을 하는 DBMS의 방식을 따른다.
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩 -> 6주차 내용
    @JoinColumn(name = "review_id", referencedColumnName = "id")
    private Review reviewId;

    private String imageUrl;
}
