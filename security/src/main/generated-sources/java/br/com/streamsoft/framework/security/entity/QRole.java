package br.com.streamsoft.framework.security.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = 1079514492L;

    public static final QRole role1 = new QRole("role1");

    public final br.com.streamsoft.framework.base.entity.impl.QLogBaseEntityImpl _super = new br.com.streamsoft.framework.base.entity.impl.QLogBaseEntityImpl(this);

    //inherited
    public final DateTimePath<java.util.Date> creationDate = _super.creationDate;

    public final StringPath description = createString("description");

    public final StringPath role = createString("role");

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    //inherited
    public final NumberPath<Long> userCreated = _super.userCreated;

    //inherited
    public final NumberPath<Long> userUpdated = _super.userUpdated;

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata metadata) {
        super(Role.class, metadata);
    }

}

