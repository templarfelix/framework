package br.com.streamsoft.framework.progress;

import com.progress.open4gl.javaproxy.Connection;

public abstract class ProgressService {

  public abstract Connection getConnection();

  public abstract Object getProgressConnection();

  public abstract Object getFacade();

}
