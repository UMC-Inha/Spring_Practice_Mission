package javalab.umc7th_mission.domian.member.service;


import jakarta.transaction.Transactional;
import javalab.umc7th_mission.apipayload.code.status.ErrorStatus;
import javalab.umc7th_mission.apipayload.exception.GeneralException;
import javalab.umc7th_mission.domian.member.Member;
import javalab.umc7th_mission.domian.member.dto.MemberConverter;
import javalab.umc7th_mission.domian.member.dto.MemberRequest;
import javalab.umc7th_mission.domian.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member joinMember(MemberRequest.JoinDto request) {
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
