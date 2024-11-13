package javalab.umc7th_mission.study.service.RestaurantService;

import javalab.umc7th_mission.study.domain.Restaurant;
import javalab.umc7th_mission.study.domain.enums.RestaurantStatus;
import javalab.umc7th_mission.study.repository.RestaurantRepository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
//@Rollback(value = false)
class RestaurantQueryServiceImplTest {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    @Rollback(false)
    void test() {
        for (int i = 0; i < 100; i++) {
            Restaurant restaurant = Restaurant.builder()
                    .address("fdjiwifd" + i)
                    .name("name" + i)
                    .type("type" + i)
                    .status(RestaurantStatus.ACTIVE)
                    .build();
            restaurantRepository.save(restaurant);
        }
    }
}