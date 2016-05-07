package br.com.streamsoft.framework.security.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserConfirm is a Querydsl query type for UserConfirm
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserConfirm extends EntityPathBase<UserConfirm> {

    private static final long serialVersionUID = 1521852591L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserConfirm userConfirm = new QUserConfirm("userConfirm");

    public final br.com.streamsoft.framework.base.entity.impl.QLogBaseEntityImpl _super = new br.com.streamsoft.framework.base.entity.impl.QLogBaseEntityImpl(this);

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

    public QUserConfirm(String variable) {
        this(UserConfirm.class, forVariable(variable), INITS);
    }

    public QUserConfirm(Path<? extends UserConfirm> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUserConfirm(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUserConfirm(PathMetadata metadata, PathInits inits) {
        this(UserConfirm.class, metadata, inits);
    }

    public QUserConfirm(Class<? extends UserConfirm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

