package io.eascycm.framework.security.entity;

import io.eascycm.framework.base.entity.impl.LogBaseEntityImpl;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

/**
 * Cria token para confirmar a a ativação do usuário.
 */
@Entity
@Table(schema = "SECURITY", name = "USER_CONFIRM",
    uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
@NamedQueries({
    @NamedQuery(name = "USERCONFIRM.FIND_ALL", query = "SELECT u FROM UserConfirm u ")
})
public class UserConfirm extends LogBaseEntityImpl<String> implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Id
  @Size(min = 1, max = 512)
  @Column(name = "id")
  private String id;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
  @JoinColumn(name = "id_user")
  private User user;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    UserConfirm other = (UserConfirm) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("\n   id=" + id);
    str.append("\n user=" + user.toString());
    return str.toString();
  }

}
