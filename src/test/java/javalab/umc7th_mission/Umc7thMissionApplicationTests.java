package javalab.umc7th_mission;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import umc.study.service.StoreService.StoreQueryService;

@SpringBootTest
class Umc7thMissionApplicationTests {

	@Autowired
	private StoreQueryService storeQueryService; // StoreQueryService 빈 주입

	@Test
	void contextLoads() {
		// StoreQueryService가 정상적으로 주입되었는지 확인
		assert(storeQueryService != null);
	}
}
