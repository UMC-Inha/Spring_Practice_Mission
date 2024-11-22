package javalab.umc7th_mission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EnableJpaRepositories -> 보통 springBoot가 알아서 리포지토리 추가시켜줌
@EnableJpaAuditing //생성일 및 업데이트일 자동 입력
public class Umc7thMissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Umc7thMissionApplication.class, args);
	}

}
