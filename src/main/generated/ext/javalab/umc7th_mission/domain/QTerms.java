package ext.javalab.umc7th_mission.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;
import javalab.umc7th_mission.domain.Terms;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTerms is a Querydsl query type for Terms
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTerms extends EntityPathBase<Terms> {

    private static final long serialVersionUID = 138004539L;

    public static final QTerms terms = new QTerms("terms");

    public final StringPath body = createString("body");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<javalab.umc7th_mission.domain.mapping.MemberAgree, ext.javalab.umc7th_mission.domain.mapping.QMemberAgree> memberAgreeList = this.<javalab.umc7th_mission.domain.mapping.MemberAgree, ext.javalab.umc7th_mission.domain.mapping.QMemberAgree>createList("memberAgreeList", javalab.umc7th_mission.domain.mapping.MemberAgree.class, ext.javalab.umc7th_mission.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final BooleanPath optional = createBoolean("optional");

    public final StringPath title = createString("title");

    public QTerms(String variable) {
        super(Terms.class, forVariable(variable));
    }

    public QTerms(Path<? extends Terms> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTerms(PathMetadata metadata) {
        super(Terms.class, metadata);
    }

}

