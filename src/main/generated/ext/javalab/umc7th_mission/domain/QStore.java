package ext.javalab.umc7th_mission.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;
import javalab.umc7th_mission.domain.Store;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = 137525141L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStore store = new QStore("store");

    public final StringPath address = createString("address");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<javalab.umc7th_mission.domain.Mission, QMission> missionList = this.<javalab.umc7th_mission.domain.Mission, QMission>createList("missionList", javalab.umc7th_mission.domain.Mission.class, QMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final QRegion region;

    public final ListPath<javalab.umc7th_mission.domain.Review, QReview> reviewList = this.<javalab.umc7th_mission.domain.Review, QReview>createList("reviewList", javalab.umc7th_mission.domain.Review.class, QReview.class, PathInits.DIRECT2);

    public final NumberPath<java.math.BigDecimal> score = createNumber("score", java.math.BigDecimal.class);

    public QStore(String variable) {
        this(Store.class, forVariable(variable), INITS);
    }

    public QStore(Path<? extends Store> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStore(PathMetadata metadata, PathInits inits) {
        this(Store.class, metadata, inits);
    }

    public QStore(Class<? extends Store> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
    }

}

