package javalab.umc7th_mission;

import javalab.umc7th_mission.service.StoreService.StoreQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;

@SpringBootApplication
@EnableJpaAuditing
public class Umc7thMissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Umc7thMissionApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			StoreQueryService storeQueryService = context.getBean(StoreQueryService.class);

			String name = "요아정";
			BigDecimal score = BigDecimal.valueOf(4.0);

			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Score: " + score);

			storeQueryService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);
		};
	}
}
