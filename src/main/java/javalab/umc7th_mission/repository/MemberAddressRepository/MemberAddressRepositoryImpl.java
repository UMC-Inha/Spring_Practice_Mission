package javalab.umc7th_mission.repository.MemberAddressRepository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import javalab.umc7th_mission.domain.mapping.MemberAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberAddressRepositoryImpl implements MemberAddressRepositoryCustom {
    private final EntityManager entityManager;
    //JPQL을 사용해 MemberAddress 엔티티에서 특정 member의 주소 조회
    @Override
    public List<MemberAddress> findAllAddressByMemberId(Long memberId) {
        String jpql = "SELECT ma FROM MemberAddress ma WHERE ma.member.id =  :memberId";
        TypedQuery<MemberAddress> query = entityManager.createQuery(jpql, MemberAddress.class);
        query.setParameter("memberId", memberId);

        return query.getResultList();
    }
}