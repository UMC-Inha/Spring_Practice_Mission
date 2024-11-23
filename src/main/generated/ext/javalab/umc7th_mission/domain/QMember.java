package ext.javalab.umc7th_mission.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;
import javalab.umc7th_mission.domain.Member;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -217390490L;

    public static final QMember member = new QMember("member1");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath email = createString("email");

    public final EnumPath<javalab.umc7th_mission.domain.enums.Gender> gender = createEnum("gender", javalab.umc7th_mission.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<javalab.umc7th_mission.domain.mapping.MemberAgree, ext.javalab.umc7th_mission.domain.mapping.QMemberAgree> memberAgreeList = this.<javalab.umc7th_mission.domain.mapping.MemberAgree, ext.javalab.umc7th_mission.domain.mapping.QMemberAgree>createList("memberAgreeList", javalab.umc7th_mission.domain.mapping.MemberAgree.class, ext.javalab.umc7th_mission.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<javalab.umc7th_mission.domain.mapping.MemberPrefer, ext.javalab.umc7th_mission.domain.mapping.QMemberPrefer> memberPreferList = this.<javalab.umc7th_mission.domain.mapping.MemberPrefer, ext.javalab.umc7th_mission.domain.mapping.QMemberPrefer>createList("memberPreferList", javalab.umc7th_mission.domain.mapping.MemberPrefer.class, ext.javalab.umc7th_mission.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath phoneNum = createString("phoneNum");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<javalab.umc7th_mission.domain.Review, QReview> reviewList = this.<javalab.umc7th_mission.domain.Review, QReview>createList("reviewList", javalab.umc7th_mission.domain.Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<javalab.umc7th_mission.domain.enums.SocialType> socialType = createEnum("socialType", javalab.umc7th_mission.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<javalab.umc7th_mission.domain.enums.MemberStatus> status = createEnum("status", javalab.umc7th_mission.domain.enums.MemberStatus.class);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

