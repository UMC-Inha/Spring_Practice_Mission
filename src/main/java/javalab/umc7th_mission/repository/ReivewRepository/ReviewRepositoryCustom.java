package javalab.umc7th_mission.repository.ReivewRepository;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Store;

public interface ReviewRepositoryCustom {
    public Long save(Member member, Store store, String body, String score);
}
