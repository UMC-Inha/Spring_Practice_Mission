package javalab.umc7th_mission.converter;

import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Region;
import javalab.umc7th_mission.domain.enums.Gender;
import javalab.umc7th_mission.domain.mapping.MemberAddress;
import javalab.umc7th_mission.repository.RegionRepository.RegionRepository;
import javalab.umc7th_mission.web.dto.MemberRequestDTO;
import javalab.umc7th_mission.web.dto.MemberResponseDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    //Member객체를 MemberResponseDTO중에 JoinResultDTO에 알맞은 객체로 변환후 반환
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return new MemberResponseDTO.JoinResultDTO(
                member.getId(),
                member.getCreatedAt()
        );
    }

    //DTO객체를 다시 Member객체로 변환시 사용 주로 쓰기 영역에서 많이 사용한다.
    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender = null;
        switch (request.getGender().getValue()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.OTHER;
                break;
            case 4:
                gender = Gender.UNKNOWN;
                break;
        }
        //member 생성 (주소는 개별)
        return Member.builder()
                .gender(gender)
                .name(request.getName())
                .nickname(request.getNickname())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .memberPreferList(new ArrayList<>())
                .point(0)
                .build();
    }

    public static MemberAddress toMemberAddress(Member member, Region region, MemberRequestDTO.JoinDto request) {
        return MemberAddress.builder()
                .member(member)
                .region(region)
                .detailAddress(request.getDetailedAddress())
                .zipCode(request.getZipcode())
                .build();
    }
}
