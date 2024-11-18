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

}
