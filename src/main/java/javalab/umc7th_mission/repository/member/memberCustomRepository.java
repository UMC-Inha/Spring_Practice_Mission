package javalab.umc7th_mission.repository.member;

import study.domian.member.dto.ResponseDto.MemberDto;

public interface memberCustomRepository {
    public MemberDto findByMemberId(Long id);
}
