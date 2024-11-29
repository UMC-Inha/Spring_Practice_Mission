package javalab.umc7th_mission.domain.memberprefer.service;

import java.util.List;
import javalab.umc7th_mission.domain.foodcategory.FoodCategory;
import javalab.umc7th_mission.domain.member.Member;
import javalab.umc7th_mission.domain.memberprefer.MemberPrefer;
import javalab.umc7th_mission.domain.memberprefer.MemberPreferConverter;
import javalab.umc7th_mission.domain.memberprefer.repository.MemberPreferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberPreferService {

    private final MemberPreferRepository memberPreferRepository;

    @Transactional
    public void saveMemberPrefers(Member member, List<FoodCategory> foodCategories) {
        List<MemberPrefer> memberPrefers = MemberPreferConverter.to(member, foodCategories);
        memberPreferRepository.saveAll(memberPrefers);
    }
}
