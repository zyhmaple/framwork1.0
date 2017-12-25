/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
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
@Service("emailServiceImpl")
public class EmailServiceImpl {
	private JavaMailSender mailSender = null;

	private MailSystemParamEntity mailSystemParamEntity = null;

	public JavaMailSender getMailSender() {
		return this.mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public MailSystemParamEntity getMailSystemParamEntity() {
		return this.mailSystemParamEntity;
	}

	public void setMailSystemParamEntity(MailSystemParamEntity mailSystemParamEntity) {
		this.mailSystemParamEntity = mailSystemParamEntity;
	}

	public void sendLZPSystemEmail(Map mailHt) throws Exception {
		MimeMessage msg = getMailSender().createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");

		String emailFrom = getMailSystemParamEntity().getEmailAdress();

		helper.setFrom(emailFrom);

		helper.setTo((String) mailHt.get("mailTo"));
		String[] cc = (String[]) mailHt.get("cc");

		if ((cc != null) && (cc.length != 0)) {
			helper.setCc(cc);
		}
		helper.setSubject((String) mailHt.get("subject"));

		String emailTemplateName = (String) mailHt.get("emailTemplateName");
		HashMap templateVarHt = (HashMap) mailHt.get("templateVarHt");
		String content = EmailContentUtil.getEmailContent(emailTemplateName, templateVarHt);
		if (((String) mailHt.get("isHtml")).equals("true")) {
			helper.setText(content, true);
			System.out.println("是html格式");
		} else {
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