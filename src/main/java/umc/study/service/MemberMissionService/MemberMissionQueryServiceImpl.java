package umc.study.service.MemberMissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepostiory.MemberMissionRepository;

import java.util.List;

@Service
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {
    private MemberMissionRepository memberMissionRepository;

    @Autowired // 생성자 주입 방식 사용
    public MemberMissionQueryServiceImpl(MemberMissionRepository memberMissionRepository) {
        this.memberMissionRepository = memberMissionRepository;
    }
    @Override
    public List<MemberMission> findMemberMissionsByMemberId(Long MemberId) {
        List<MemberMission> filteredMemberMissions = memberMissionRepository.dynamicQueryWithBooleanBuilder(MemberId);

        filteredMemberMissions.forEach(mission -> System.out.println("MemberMission: " + mission));

        return filteredMemberMissions;
    }
}
