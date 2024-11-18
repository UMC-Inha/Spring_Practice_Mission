package ext.javalab.umc7th_mission.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;
import javalab.umc7th_mission.domain.mapping.MemberMission;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberMission is a Querydsl query type for MemberMission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberMission extends EntityPathBase<MemberMission> {

    private static final long serialVersionUID = -1459644634L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberMission memberMission = new QMemberMission("memberMission");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ext.javalab.umc7th_mission.domain.QMember member;

    public final ext.javalab.umc7th_mission.domain.QMission mission;

    public final EnumPath<javalab.umc7th_mission.domain.enums.MissionStatus> status = createEnum("status", javalab.umc7th_mission.domain.enums.MissionStatus.class);

    public QMemberMission(String variable) {
        this(MemberMission.class, forVariable(variable), INITS);
    }

    public QMemberMission(Path<? extends MemberMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberMission(PathMetadata metadata, PathInits inits) {
        this(MemberMission.class, metadata, inits);
    }

    public QMemberMission(Class<? extends MemberMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new ext.javalab.umc7th_mission.domain.QMember(forProperty("member")) : null;
        this.mission = inits.isInitialized("mission") ? new ext.javalab.umc7th_mission.domain.QMission(forProperty("mission"), inits.get("mission")) : null;
    }

}

