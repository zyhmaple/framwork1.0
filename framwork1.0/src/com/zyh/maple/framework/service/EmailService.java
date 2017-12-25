/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.framework.service;

import javax.mail.MessagingException;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Scope(value="singleton")
@Service(value="emailService")
public interface EmailService {
    public void sendEmail(String var1, Object var2, Integer var3) throws MessagingException;

    public void setMailSender(JavaMailSender var1);

    public void sendAttachmentEmail(String var1, String var2, String var3, String var4, String[] var5) throws Exception;
}

