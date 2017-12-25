/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  org.springframework.context.support.ClassPathXmlApplicationContext
 */
package com.zyh.maple.framework.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyh.maple.framework.service.impl.EmailServiceImpl;

public class EmailContentUtil {
    public static String getEmailContent(String htmlFileName, Map<String,String> emailHt) {
        String emailcontent = null;
        try {
            String rootpath = EmailContentUtil.class.getResource("/conf/emailtemplate/").getPath();
            File htmlf = new File(String.valueOf(rootpath) + htmlFileName);
            FileInputStream htmlFile = new FileInputStream(htmlf);
            DataInputStream dinput = new DataInputStream(htmlFile);
            byte[] htmlFileByte = new byte[(int)htmlf.length()];
            dinput.readFully(htmlFileByte);
            dinput.close();
            htmlFile.close();
            String htmlFileStr = new String(htmlFileByte, "UTF-8");
            System.out.println("htmlFileStr = " + htmlFileStr);
            for (String keyStr : emailHt.keySet()) {
                String valueStr = (String)emailHt.get(keyStr);
                htmlFileStr = htmlFileStr.replaceAll(keyStr, valueStr);
            }
            emailcontent = htmlFileStr;
            System.out.println("emailcontent = " + emailcontent);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return emailcontent;
    }

    public static void main(String[] arg0) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"/conf/spring/applicationContext.xml", "/conf/spring/applicationContext-action-email.xml"});
        EmailServiceImpl lzpes = (EmailServiceImpl)context.getBean("artUpEmailService");
        HashMap<String, String> ht = new HashMap<String, String>();
        ht.put("#userName#", "testName");
        ht.put("#messageContent#", "testContent");
        ht.put("#url#", "http://www.lezipu.com");
        ht.put("#lzpImage0#", "http://www.lezipu.com/UploadFolder/1231733112025-8847047604806362444_min.jpg");
        ht.put("#lzpImage1#", "http://www.lezipu.com/UploadFolder/1232504947444-4976689651162208148_min.jpg");
        HashMap<String, Object> sendEamilHt = new HashMap<String, Object>();
        sendEamilHt.put("emailTemplateName", "11.html");
        sendEamilHt.put("templateVarHt", ht);
        sendEamilHt.put("mailTo", "twtymih2008@gmail.com");
        String[] cc = new String[]{"twtymih2000@sina.com"};
        sendEamilHt.put("cc", cc);
        sendEamilHt.put("subject", "\u8fd9\u662f\u4e00\u4e2a\u6d4b\u8bd5");
        sendEamilHt.put("isHtml", "true");
        try {
            lzpes.sendLZPSystemEmail(sendEamilHt);
            System.out.println("\u53d1\u9001email\u6210\u529f");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

