package javalab.umc7th_mission.domian.mission.dto;


import java.util.List;
import javalab.umc7th_mission.domian.enums.MissionStatus;
import javalab.umc7th_mission.domian.member.Member;
import javalab.umc7th_mission.domian.membermission.MemberMission;
import javalab.umc7th_mission.domian.mission.Mission;
import javalab.umc7th_mission.domian.mission.dto.MissionResponse.MissionInfo;
import javalab.umc7th_mission.domian.store.Store;
import org.springframework.data.domain.Page;

public class MissionConverter {
    public Mission toEntity(MissionRequest.AddMission request, Store store) {
        return Mission.builder()
            .store(store)
            .reward(Math.toIntExact(request.getReward()))
            .build();
    }

    public MissionResponse.AddMission toAddMissionResponse(Mission mission) {
        return MissionResponse.AddMission.builder()
            .missionId(mission.getId())
            .storeId(mission.getStore().getId())
            .build();
    }

    public MemberMission toMMEntity(MissionRequest.ActiveMission request, Member member,Mission mission) {
        return MemberMission.builder()
            .member(member)
            .mission(mission)
            .status(MissionStatus.CHALLENGING)
            .build();
    }

    public MissionResponse.ActiveMission toActiveMission(MemberMission memberMission) {
        return MissionResponse.ActiveMission.builder()
            .missionId(memberMission.getMission().getId())
            .build();
    }

    public MissionResponse.ActiveMissionList toMissionInfoList(Page<MemberMission> memberMissions) {
        List<MissionInfo> list = memberMissions.stream().map(
            mm -> MissionResponse.MissionInfo.builder()
                .storeId(mm.getMission().getStore().getId())
                .storeName(mm.getMission().getStore().getName())
                .content(mm.getMission().getMissionSpec())
                .reward(Long.valueOf(mm.getMission().getReward()))
                .build()
        ).toList();

        return MissionResponse.ActiveMissionList.builder()
            .missionInfos(list)
            .build();
    }

    public MissionResponse.CompleteMission toCompleteMission(MemberMission memberMission) {
        return MissionResponse.CompleteMission.builder()
            .memberId(memberMission.getMember().getId())
            .missionId(memberMission.getMission().getId())
            .status(memberMission.getStatus())
            .build();
    }


}
