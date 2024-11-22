package umc.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.study.domain.Review;
import umc.study.service.MemberMissionService.MemberMissionQueryService;
import umc.study.service.MemberService.MemberQueryService;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.service.StoreService.StoreQueryService;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class Umc7thMissionApplication {

	public static void main(String[] args) {

		SpringApplication.run(Umc7thMissionApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeService = context.getBean(StoreQueryService.class);
			MemberMissionQueryService memberMissionService = context.getBean(MemberMissionQueryService.class);
			ReviewQueryService reviewService = context.getBean(ReviewQueryService.class);
			MissionQueryService missionService = context.getBean(MissionQueryService.class);
			MemberQueryService memberService = context.getBean(MemberQueryService.class);

			String name = "한우곱창";
			Long memberId = 2L;
			Long storeId = 7L;
			Long regionId = 1L;
			Long userId = 1L;

//			System.out.println("Executing findStoresByNameAndScore with parameters:");
//			System.out.println("Name: " + name);
//			storeService.findStoresByName(name).forEach(System.out::println);
//
//			System.out.println("Executing findMemberMissionsByStoreId with parameters:");
//			System.out.println("MemberId: " + memberId);
//			memberMissionService.findMemberMissionsByMemberId(memberId).forEach(System.out::println);
//
//			System.out.println("Executing findReviewsByStoreId with parameters:");
//			System.out.println("StoreId: " + storeId);
//			System.out.println("MemberId: " + memberId);
//			reviewService.findReviewByMemberIdAndStoreId(storeId,memberId).forEach(System.out::println);
//
//			System.out.println("Executing findMissionsWithCompletedCountByRegion with parameters:");
//			System.out.println("RegionId: " + regionId);
//			missionService.findMissionsWithCompletedCountByRegion(regionId).forEach(System.out::println);

			System.out.println("Executing findMemberDetailsById with parameters:");
			System.out.println("UserId: " + userId);
			memberService.findMemberByMemberDetailsId(userId).forEach(System.out::println);
		};
	}
}
