package com.zyh.maple.framework.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Scope;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.zyh.maple.framework.model.MailSystemParamEntity;
import com.zyh.maple.framework.util.EmailContentUtil;

@Scope("singleton")
@Service("lzpEmailServiceImpl")
public class LZPEmailServiceImpl
{
  private JavaMailSender mailSender = null;

  private MailSystemParamEntity mailSystemParamEntity = null;

  public JavaMailSender getMailSender()
  {
    return this.mailSender;
  }

  public void setMailSender(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  public MailSystemParamEntity getMailSystemParamEntity() {
    return this.mailSystemParamEntity;
  }

  public void setMailSystemParamEntity(MailSystemParamEntity mailSystemParamEntity)
  {
    this.mailSystemParamEntity = mailSystemParamEntity;
  }

  public void sendLZPSystemEmail(Map lzpMailHt)
    throws Exception
  {
    MimeMessage msg = getMailSender().createMimeMessage();

    MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");

    String emailFrom = getMailSystemParamEntity().getEmailAdress();

    helper.setFrom(emailFrom);

    helper.setTo((String)lzpMailHt.get("mailTo"));
    String[] cc = (String[])lzpMailHt.get("cc");

    if ((cc != null) && (cc.length != 0))
    {
      helper.setCc(cc);
    }
    helper.setSubject((String)lzpMailHt.get("subject"));

    String emailTemplateName = (String)lzpMailHt.get("emailTemplateName");
    HashMap templateVarHt = (HashMap)lzpMailHt.get("templateVarHt");
    String content = EmailContentUtil.getEmailContent(emailTemplateName, templateVarHt);
    if (((String)lzpMailHt.get("isHtml")).equals("true"))
    {
      helper.setText(content, true);
      System.out.println("是html格式");
    }
    else
    {
      helper.setText(content);
    }

    try {
		getMailSender().send(msg);
	} catch (MailException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}