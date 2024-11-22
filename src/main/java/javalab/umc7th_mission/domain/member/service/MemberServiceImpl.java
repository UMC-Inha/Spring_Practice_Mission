package javalab.umc7th_mission.domain.member.service;

import java.util.List;
import javalab.umc7th_mission.domain.foodcategory.FoodCategory;
import javalab.umc7th_mission.domain.foodcategory.service.FoodCategoryService;
import javalab.umc7th_mission.domain.member.Member;
import javalab.umc7th_mission.domain.member.dto.MemberConverter;
import javalab.umc7th_mission.domain.member.dto.MemberRequest.JoinDTO;
import javalab.umc7th_mission.domain.member.dto.MemberResponse;
import javalab.umc7th_mission.domain.member.repository.MemberRepository;
import javalab.umc7th_mission.domain.memberprefer.service.MemberPreferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberPreferService memberPreferService;
    private final FoodCategoryService foodCategoryService;

    @Override
    @Transactional
    public MemberResponse.JoinResultDTO join(JoinDTO request) {
        Member member = MemberConverter.to(request);
        memberRepository.save(member);

        List<FoodCategory> foodCategories = foodCategoryService
                .getByIds(request.preferCategoryIds());

        memberPreferService.saveMemberPrefers(member, foodCategories);

        return MemberConverter.to(member);
    }

}
