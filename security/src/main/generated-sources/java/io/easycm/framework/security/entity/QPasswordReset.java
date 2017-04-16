package io.easycm.framework.security.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPasswordReset is a Querydsl query type for PasswordReset
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPasswordReset extends EntityPathBase<PasswordReset> {

    private static final long serialVersionUID = 916333645L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPasswordReset passwordReset = new QPasswordReset("passwordReset");

    public final io.easycm.framework.base.entity.impl.QLogBaseEntityImpl _super = new io.easycm.framework.base.entity.impl.QLogBaseEntityImpl(this);

    //inherited
    public final DateTimePath<java.util.Date> creationDate = _super.creationDate;

    public final StringPath id = createString("id");

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public final QUser user;

    //inherited
    public final NumberPath<Long> userCreated = _super.userCreated;

    //inherited
    public final NumberPath<Long> userUpdated = _super.userUpdated;

    public QPasswordReset(String variable) {
        this(PasswordReset.class, forVariable(variable), INITS);
    }

    public QPasswordReset(Path<? extends PasswordReset> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPasswordReset(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPasswordReset(PathMetadata metadata, PathInits inits) {
        this(PasswordReset.class, metadata, inits);
    }

    public QPasswordReset(Class<? extends PasswordReset> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

