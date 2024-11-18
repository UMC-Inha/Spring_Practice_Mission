package ext.javalab.umc7th_mission.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;
import javalab.umc7th_mission.domain.Mission;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission is a Querydsl query type for Mission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission extends EntityPathBase<Mission> {

    private static final long serialVersionUID = 1971397440L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMission mission = new QMission("mission");

    public final DateTimePath<java.time.LocalDateTime> deadline = createDateTime("deadline", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<javalab.umc7th_mission.domain.mapping.MemberMission, ext.javalab.umc7th_mission.domain.mapping.QMemberMission> memberMissionList = this.<javalab.umc7th_mission.domain.mapping.MemberMission, ext.javalab.umc7th_mission.domain.mapping.QMemberMission>createList("memberMissionList", javalab.umc7th_mission.domain.mapping.MemberMission.class, ext.javalab.umc7th_mission.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final StringPath missionSpec = createString("missionSpec");

    public final NumberPath<Integer> reward = createNumber("reward", Integer.class);

    public final QStore store;

    public QMission(String variable) {
        this(Mission.class, forVariable(variable), INITS);
    }

    public QMission(Path<? extends Mission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMission(PathMetadata metadata, PathInits inits) {
        this(Mission.class, metadata, inits);
    }

    public QMission(Class<? extends Mission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

