package umc.study.repository.MemberMissionRepostiory;

import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMission> dynamicQueryWithBooleanBuilder(Long id);
}
