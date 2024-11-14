package javalab.umc7th_mission.repository.MemberRepository;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.web.dto.MemberInfoDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepositoryCustom {
    MemberInfoDto findMemberInfoById(Long memberId);
}
