package br.com.streamsoft.framework.progress;

import java.sql.Types;
import org.hibernate.dialect.ProgressDialect;

/**
 * @author Fernando
 * @version 2.0
 */
public class OpenEdgeDialect extends ProgressDialect {

  public OpenEdgeDialect() {
    super();
    registerColumnType(Types.CLOB, "CLOB");
    registerColumnType(Types.BLOB, "BLOB");
  }

  public char openQuote() {
    return '"';
  }

  public char closeQuote() {
    return '"';
  }

}