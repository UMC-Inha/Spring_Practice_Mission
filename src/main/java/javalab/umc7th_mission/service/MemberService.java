package javalab.umc7th_mission.service;

import javalab.global.apiPayload.code.status.ErrorStatus;
import javalab.global.apiPayload.exception.GeneralException;
import javalab.umc7th_mission.converter.MemberConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.repository.MemberRepository;
import javalab.umc7th_mission.web.dto.request.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toEntity(request);
        memberRepository.save(newMember);
        return newMember;
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND)
        );
    }
}
