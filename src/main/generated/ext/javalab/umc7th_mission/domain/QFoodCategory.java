package ext.javalab.umc7th_mission.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;
import javalab.umc7th_mission.domain.FoodCategory;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodCategory is a Querydsl query type for FoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodCategory extends EntityPathBase<FoodCategory> {

    private static final long serialVersionUID = -2143011256L;

    public static final QFoodCategory foodCategory = new QFoodCategory("foodCategory");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<javalab.umc7th_mission.domain.mapping.MemberPrefer, ext.javalab.umc7th_mission.domain.mapping.QMemberPrefer> memberPreferList = this.<javalab.umc7th_mission.domain.mapping.MemberPrefer, ext.javalab.umc7th_mission.domain.mapping.QMemberPrefer>createList("memberPreferList", javalab.umc7th_mission.domain.mapping.MemberPrefer.class, ext.javalab.umc7th_mission.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public QFoodCategory(String variable) {
        super(FoodCategory.class, forVariable(variable));
    }

    public QFoodCategory(Path<? extends FoodCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodCategory(PathMetadata metadata) {
        super(FoodCategory.class, metadata);
    }

}

