package javalab.umc7th_mission.service.MemberService;

import jakarta.transaction.Transactional;
import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.apiPayload.exception.FoodCategoryNotFoundException;
import javalab.umc7th_mission.apiPayload.exception.RegionNotFoundException;
import javalab.umc7th_mission.converter.MemberConverter;
import javalab.umc7th_mission.converter.MemberPreferConverter;
import javalab.umc7th_mission.domain.FoodCategory;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Region;
import javalab.umc7th_mission.domain.mapping.MemberAddress;
import javalab.umc7th_mission.domain.mapping.MemberPrefer;
import javalab.umc7th_mission.repository.FoodCategoryRepository.FoodCategoryRepository;
import javalab.umc7th_mission.repository.MemberAddressRepository.MemberAddressRepository;
import javalab.umc7th_mission.repository.MemberRepository.MemberRepository;
import javalab.umc7th_mission.repository.RegionRepository.RegionRepository;
import javalab.umc7th_mission.web.dto.MemberRequestDTO;
import javalab.umc7th_mission.web.dto.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;
    private final RegionRepository regionRepository;
    private final MemberAddressRepository memberAddressRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional //트렌잭션 어노테이션
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Region region = regionRepository.findByName(request.getRegion());
        if (region == null) {
            throw new RegionNotFoundException(ErrorStatus.REGION_NOT_FOUND);
        }

        //member 생성 및 저장
        Member newMember = MemberConverter.toMember(request);
        //foodCategory list 조회
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryNotFoundException(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        //list 생성 및 Member와 연결
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});
        newMember.setMemberPreferList(memberPreferList);

        //24.11.21 fix/#7
        //memberAddress 생성 및 연결
        MemberAddress memberAddress = MemberConverter.toMemberAddress(newMember, region, request);


        memberAddress.setMember(newMember);
        newMember.setAddress(memberAddress);

        memberAddressRepository.save(memberAddress);

        return memberRepository.save(newMember);
    }
}