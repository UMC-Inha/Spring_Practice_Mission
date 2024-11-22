package javalab.umc7th_mission.repository.MemberAddressRepository;

import javalab.umc7th_mission.domain.mapping.MemberAddress;

import java.util.List;

public interface MemberAddressRepositoryCustom {
    List<MemberAddress> findAllAddressByMemberId(Long memberId);
}