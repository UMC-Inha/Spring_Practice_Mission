package javalab.umc7th_mission.service.MemberMissionService;

import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import javalab.umc7th_mission.repository.MemberMissionRepository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<MemberMission> getMemberMissionInProgressList(Long memberId, Integer page) {
        return memberMissionRepository.findAllByMemberIdAndStatus(memberId, MissionStatus.IN_PROGRESS, PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "createdAt")));
    }
}
