package javalab.umc7th_mission.service.MemberMissionQueryService;

import javalab.umc7th_mission.converter.MemberMissionConverter;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.repository.MemberMissionRepository.MemberMissionRepository;
import javalab.umc7th_mission.web.dto.MemberMissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberMissionResponseDTO.ChallengingMissionPreviewListDTO getChallengingMemberMissions(Long memberId, Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.by("createdAt").descending());

        //1. 일단 멤버미션 페이징 조회
        Page<MemberMission> memberMissions = memberMissionRepository.findChallengingMissionByMemberId(memberId, pageRequest);

        return MemberMissionConverter.challengingMissionPreviewListDTO(memberMissions);
    }
}
