package javalab.umc7th_mission.study.service.MemberMissionService;

import javalab.umc7th_mission.study.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.study.apiPayload.exception.GeneralException;
import javalab.umc7th_mission.study.converter.MemberMissionConverter;
import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.domain.Mission;
import javalab.umc7th_mission.study.domain.mapping.MemberMission;
import javalab.umc7th_mission.study.repository.MemberMissionRepository.MemberMissionRepository;
import javalab.umc7th_mission.study.repository.MemberRepository.MemberRepository;
import javalab.umc7th_mission.study.repository.MissionRepository.MissionRepository;
import javalab.umc7th_mission.study.web.dto.member_mission.MemberMissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
   private final MemberMissionRepository memberMissionRepository;
   private final MemberRepository memberRepository;
   private final MissionRepository missionRepository;

   @Override
    public MemberMission AddMemberMission(MemberMissionRequestDTO.AddMemberMissionDto request){
       Member member = memberRepository.findById(request.getMemberId())
               .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

       Mission mission = missionRepository.findById(Math.toIntExact(request.getMissionId()))
               .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

       MemberMission membermission = MemberMissionConverter.toMemberMission(member, mission);



       return memberMissionRepository.save(membermission);
   }

   @Override
    public boolean isExist(Long memberId, Long missionId){
      MemberMission memberMission = memberMissionRepository.findMemberMissionByMemberIdAndMissionId(memberId, missionId);

       if(memberMission != null){
           return true;
       }
       return false;
   }
}
