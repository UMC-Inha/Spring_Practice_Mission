package javalab.umc7th_mission.repository.ReviewRepository;

import javalab.umc7th_mission.web.dto.MemberDto;
import java.util.List;

public interface ReviewRepositoryCustom {
    List<MemberDto> findMembersByStoreId(Long storeId);
}
