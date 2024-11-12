package javalab.umc7th_mission.domain.member.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;

public interface CustomMemberRepository {

    JPAQuery<Tuple> missionFour(Long userId);

}
