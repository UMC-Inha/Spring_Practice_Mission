package javalab.umc7th_mission.repository.ReviewRepository;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Store;

import java.math.BigDecimal;

public interface ReviewRepositoryCustom {
    public Long save(Member member, Store store, String content, BigDecimal rating);
}
