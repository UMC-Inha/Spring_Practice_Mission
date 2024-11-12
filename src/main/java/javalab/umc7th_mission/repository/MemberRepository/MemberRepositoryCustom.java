package javalab.umc7th_mission.repository.MemberRepository;

import javalab.umc7th_mission.web.dto.MemberDto;

public interface MemberRepositoryCustom {
    MemberDto findMemberDtoById(Long id);
}