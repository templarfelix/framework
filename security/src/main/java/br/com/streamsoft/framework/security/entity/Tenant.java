package br.com.streamsoft.framework.security.entity;

import br.com.streamsoft.framework.base.entity.impl.BaseEntityImpl;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.annotations.GenericGenerator;

/**
 * Created by Fernando on 29/03/2016.
 */
@Entity
@Table(name = "TENANT",
    schema = "SECURITY")
@NamedQueries({@NamedQuery(
    name = "TENANT.FIND_ALL",
    query = "SELECT u FROM Tenant u ")})
public class Tenant extends BaseEntityImpl<UUID> implements Serializable {

  @Id
  @Column(name = "id")
  @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
  @GeneratedValue(generator = "uuid-gen")
  //@Type(type="pg-uuid")
  private UUID id;

  @Column(nullable = false,
      updatable = false)
  private String name;

  @Column(nullable = false,
      updatable = false)
  private String schemaName;

  @Version
  private Long version;

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSchemaName() {
    return schemaName;
  }

  public void setSchemaName(String schemaName) {
    this.schemaName = schemaName;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

}