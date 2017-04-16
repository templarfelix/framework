package io.easycm.framework.security.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTenant is a Querydsl query type for Tenant
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTenant extends EntityPathBase<Tenant> {

    private static final long serialVersionUID = -1173687823L;

    public static final QTenant tenant = new QTenant("tenant");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath name = createString("name");

    public final StringPath schemaName = createString("schemaName");

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QTenant(String variable) {
        super(Tenant.class, forVariable(variable));
    }

    public QTenant(Path<? extends Tenant> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTenant(PathMetadata metadata) {
        super(Tenant.class, metadata);
    }

}

