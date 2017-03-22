package br.com.streamsoft.framework.base.mail;

import java.io.Serializable;

/**
 *
 * */
public interface Mail extends Serializable {

  /**
   * @param from
   * @param to
   * @param subject
   * @param body
   * @throws Exception
   */
  public void sendEmailText(String from, String to, String subject, String body) throws Exception;

  /**
   * @param from
   * @param to
   * @param subject
   * @param body
   * @throws Exception
   */
  public void sendEmailHtml(String from, String to, String subject, String body) throws Exception;

}
