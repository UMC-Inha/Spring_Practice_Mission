package javalab.umc7th_mission.study.service.MemberService;

import javalab.umc7th_mission.study.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.study.apiPayload.exception.GeneralException;
import javalab.umc7th_mission.study.converter.MemberConverter;
import javalab.umc7th_mission.study.converter.MemberFoodConverter;
import javalab.umc7th_mission.study.domain.Food;
import javalab.umc7th_mission.study.domain.mapping.MemberFood;
import javalab.umc7th_mission.study.repository.MemberRepository.MemberRepository;
import javalab.umc7th_mission.study.domain.Member;
import javalab.umc7th_mission.study.repository.RestaurantRepository.FoodRepository;
import javalab.umc7th_mission.study.web.dto.member.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request){
        Member newMember = MemberConverter.toMember(request);

        List<Food> foodList = request.getMemberFoodList().stream()
                .map(category -> {
                    return foodRepository.findById(category).orElseThrow(() -> new GeneralException(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());
        List<MemberFood> memberFoodList = MemberFoodConverter.toMemberFoodList(foodList);

        memberFoodList.forEach(memberFood -> {memberFood.setMember(newMember);});

        return memberRepository.save(newMember);
    }

}
