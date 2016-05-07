package br.com.streamsoft.framework.base.entity.impl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLogBaseEntityImpl is a Querydsl query type for LogBaseEntityImpl
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QLogBaseEntityImpl extends EntityPathBase<LogBaseEntityImpl<? extends java.io.Serializable>> {

    private static final long serialVersionUID = -2055376383L;

    public static final QLogBaseEntityImpl logBaseEntityImpl = new QLogBaseEntityImpl("logBaseEntityImpl");

    public final DateTimePath<java.util.Date> creationDate = createDateTime("creationDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> updatedDate = createDateTime("updatedDate", java.util.Date.class);

    public final NumberPath<Long> userCreated = createNumber("userCreated", Long.class);

    public final NumberPath<Long> userUpdated = createNumber("userUpdated", Long.class);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QLogBaseEntityImpl(String variable) {
        super((Class) LogBaseEntityImpl.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QLogBaseEntityImpl(Path<? extends LogBaseEntityImpl> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QLogBaseEntityImpl(PathMetadata metadata) {
        super((Class) LogBaseEntityImpl.class, metadata);
    }

}

