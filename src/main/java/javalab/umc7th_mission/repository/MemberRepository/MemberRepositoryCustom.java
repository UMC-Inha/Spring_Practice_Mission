package javalab.umc7th_mission.repository.MemberRepository;

import javalab.umc7th_mission.web.dto.MyPageDto;

import java.util.List;

public interface MemberRepositoryCustom {
    public List<MyPageDto> findMemberSpecByMemberId(Long id);
}
