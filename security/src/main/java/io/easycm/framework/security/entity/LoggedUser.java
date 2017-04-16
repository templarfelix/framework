package io.easycm.framework.security.entity;

import java.util.Date;
import java.util.UUID;

/**
 * @author Fernando <fernando@mksdev.com>
 * @version 0.0.1-SNAPSHOT-SNAPSHOT
 */
public class LoggedUser {

  private String sessionID;

  private UUID id;

  private String login;

  private String name;

  private Date lastLogin;

  private String image;

  public String getSessionID() {
    return sessionID;
  }

  public void setSessionID(String sessionID) {
    this.sessionID = sessionID;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(Date lastLogin) {
    this.lastLogin = lastLogin;
  }

  public String getImage() {
    // FIXME PEGAR A IMAGEM CORRETA
    return "R0lGODlhUAAPAKIAAAsLav///88PD9WqsYmApmZmZtZfYmdakyH5BAQUAP8ALAAAAABQAA8AAAPbWLrc/jDKSVe4OOvNu/9gqARDSRBHegyGMahqO4R0bQcjIQ8E4BMCQc930JluyGRmdAAcdiigMLVrApTYWy5FKM1IQe+Mp+L4rphz+qIOBAUYeCY4p2tGrJZeH9y79mZsawFoaIRxF3JyiYxuHiMGb5KTkpFvZj4ZbYeCiXaOiKBwnxh4fnt9e3ktgZyHhrChinONs3cFAShFF2JhvCZlG5uchYNun5eedRxMAF15XEFRXgZWWdciuM8GCmdSQ84lLQfY5R14wDB5Lyon4ubwS7jx9NcV9/j5+g4JADs=";
    // return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("\n sessionID=" + sessionID);
    str.append("\n        id=" + id);
    str.append("\n     login=" + login);
    str.append("\n      name=" + name);
    str.append("\n lastLogin=" + lastLogin);
    return str.toString();
  }
}
