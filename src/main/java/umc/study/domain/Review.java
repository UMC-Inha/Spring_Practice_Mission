package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store storeId;

    private Long score;
    private String content;

    @OneToMany(mappedBy = "reviewId", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImageList = new ArrayList<>();

    @Builder
    public Review(Member memberId, Store storeId, Long score, String content, List<ReviewImage> reviewImageList) {
        this.memberId = memberId;
        this.storeId = storeId;
        this.score = score;
        this.content = content;
        this.reviewImageList = reviewImageList != null ? reviewImageList : new ArrayList<>();
    }
}
