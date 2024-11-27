package javalab.umc7th_mission.service.MemberQueryService;

import javalab.umc7th_mission.repository.MemberRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;


    //MemberValidationService를 만들지 않고 QueryService안에 포함했는데, 이후 너무 확장되면 분리 필요있음
    @Override
    public boolean isMemberExist(Long memberId) {
        return memberRepository.existsById(memberId);
    }
}
