package javalab.umc7th_mission.repository.MemberMissionRepository;

import javalab.umc7th_mission.domain.mapping.MemberMission;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> findChallengingByMember(Long memberId, String regionName, Pageable pageable);

    List<MemberMission> findCompleteByMember(Long memberId, String regionName, Pageable pageable);

    Long countCompleteByMember(Long memberId, String regionName);
}
