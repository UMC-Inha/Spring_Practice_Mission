package javalab.umc7th_mission.study.repository.RestaurantRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ext.javalab.umc7th_mission.study.domain.QRestaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ext.javalab.umc7th_mission.study.domain.QRestaurant;
import javalab.umc7th_mission.study.domain.Restaurant;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QRestaurant restaurant = QRestaurant.restaurant;

    @Override
    public List<Restaurant> dynamicQueryWithBooleanBuilder(String name){
        BooleanBuilder predicate = new BooleanBuilder();

        if(name != null){
            predicate.and(restaurant.name.eq(name));
        }

        return queryFactory
                .selectFrom(restaurant)
                .where(predicate)
                .fetch();

    }
}
