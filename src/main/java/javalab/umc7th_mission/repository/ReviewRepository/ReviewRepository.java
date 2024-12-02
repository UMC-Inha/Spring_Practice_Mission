package javalab.umc7th_mission.repository.ReviewRepository;

import jakarta.transaction.Transactional;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

//24.11.19 @Repository add
@Repository
//24.11.26 [docs] Integer -> Long 수정;
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Review (member_id, store_id, content, rating) VALUES (:memberId, :storeId, :content, :rating)", nativeQuery = true)
    void insertReview(@Param("memberId") Long memberId,
                      @Param("storeId") Long storeId,
                      @Param("content") String content,
                      @Param("rating") BigDecimal rating
                      );


    /*
    Page 클래스 -> 페이징된 결과를 표현하는 데이터 컨테이너 인터페이스
    페이징 처리된 결과 데이터(실제 조회된 데이터)를 포함한다.
    페이징과 관련된 메타데이터(페이지 번호, 총 페이지 수, 총 데이터 개수 등)를 함께 제공한다.
    데이터와 페이징 정보를 모두 포함하므로, REST API에서 페이징 응답에 적합하다.

    PageRequest 객체 -> Spring Data JPA에서 페이징 요청을 만들기 위한 페이지 설정 객체
    페이징 요청을 정의하기 위한 클래스이다.
    페이지 번호, 페이지 크기, 정렬 조건 등을 설정할 수 있다.
    Pageable 인터페이스의 구현체 중 하나로, JPA 리포지토리에서 페이징 처리를 수행할 때 사용된다.
     */
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findByMemberId(Long memberId, Pageable pageable);
}