package javalab.umc7th_mission.repository.MemberMissionRepository;


import javalab.umc7th_mission.domain.enums.MissionStatus;
import javalab.umc7th_mission.domain.mapping.MemberMission;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MemberMissionRepositoryCustom {
    List<MemberMission> findChallengingMissionByMember(Long memberId, Pageable pageable);
    List<MemberMission> findCompletedMissionByMember(Long memberId, Pageable pageable);
    Long countCompletedMissionByMember(Long memberId, String regionName);
}
