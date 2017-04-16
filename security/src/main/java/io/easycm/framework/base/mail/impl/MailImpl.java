package io.easycm.framework.base.mail.impl;

import io.easycm.framework.base.mail.Mail;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * MailImpl
 */
@Named
public class MailImpl implements Mail {

  private static final long serialVersionUID = 1L;

  /**
   *
   */
  @Resource(mappedName = "java:jboss/mail/Default")
  private Session sessionMail;

  /**
   *
   **/
  public void sendEmailText(String from, String to, String subject, String body) throws Exception {
    MimeMessage message = new MimeMessage(sessionMail);
    message.setFrom(new InternetAddress(from));
    InternetAddress[] toAddress = InternetAddress.parse(to);
    message.addRecipients(Message.RecipientType.TO, toAddress);
    message.setSubject(subject, "UTF-8");
    message.setContent(body, "text/plain; charset=utf-8");
    Transport.send(message);
  }

  /**
   *
   **/
  public void sendEmailHtml(String from, String to, String subject, String body) throws Exception {
    MimeMessage message = new MimeMessage(sessionMail);
    message.setFrom(new InternetAddress(from));
    InternetAddress[] toAddress = InternetAddress.parse(to);
    message.addRecipients(Message.RecipientType.TO, toAddress);
    message.setSubject(subject, "UTF-8");
    message.setContent(body, "text/html; charset=utf-8");
    Transport.send(message);
  }

}