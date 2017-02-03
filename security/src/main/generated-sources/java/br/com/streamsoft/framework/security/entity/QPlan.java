package br.com.streamsoft.framework.security.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlan is a Querydsl query type for Plan
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlan extends EntityPathBase<Plan> {

    private static final long serialVersionUID = 1079451695L;

    public static final QPlan plan = new QPlan("plan");

    public final br.com.streamsoft.framework.base.entity.impl.QLogBaseEntityImpl _super = new br.com.streamsoft.framework.base.entity.impl.QLogBaseEntityImpl(this);

    //inherited
    public final DateTimePath<java.util.Date> creationDate = _super.creationDate;

    public final NumberPath<Long> daysForExpire = createNumber("daysForExpire", Long.class);

    public final StringPath description = createString("description");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    //inherited
    public final NumberPath<Long> userCreated = _super.userCreated;

    //inherited
    public final NumberPath<Long> userUpdated = _super.userUpdated;

    public final NumberPath<java.math.BigDecimal> value = createNumber("value", java.math.BigDecimal.class);

    public QPlan(String variable) {
        super(Plan.class, forVariable(variable));
    }

    public QPlan(Path<? extends Plan> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlan(PathMetadata metadata) {
        super(Plan.class, metadata);
    }

}

