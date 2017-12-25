/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.framework.service.impl;

import java.net.URLDecoder;
import java.nio.charset.Charset;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zyh.maple.framework.util.InterfaceConnentUtil;
import com.zyh.maple.framework.util.UTF8EncodeUtil;

@Scope(value = "singleton")
@Service(value = "messageSenderService")
public class MessageSenderServiceImpl {
	private String corpID = null;
	private String corpPWD = null;
	private String corpService = null;
	private String serverURL = null;
	private StringBuffer sb = null;

	public String sendMessage(String mobile, String msgContent, String corpMsgID, Integer extNum) {
		StringBuffer httpSb = this.createHttpHeadURL();
		httpSb.append("&mobile=");
		httpSb.append(mobile);
		httpSb.append("&msg_content=");
		httpSb.append(MessageSenderServiceImpl.utf2Other(msgContent));
		if (corpMsgID != null) {
			httpSb.append("&corp_msg_id=");
			httpSb.append(corpMsgID);
		}
		if (extNum != null) {
			httpSb.append("&ext=");
			httpSb.append(extNum);
		}
		System.out.println("\u53d1\u9001\u7684url = " + httpSb.toString());
		String resultStr = "108";
		try {
			resultStr = InterfaceConnentUtil.sendURLAndGetStr(httpSb.toString(), "gbk");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultStr;
	}

	public String sendMessage(String mobile, String msgContent, String corpMsgID) {
		return this.sendMessage(mobile, msgContent, corpMsgID, null);
	}

	public String sendMessage(String mobile, String msgContent, Integer extNum) {
		return this.sendMessage(mobile, msgContent, null, extNum);
	}

	public String sendMessage(String mobile, String msgContent) {
		return this.sendMessage(mobile, msgContent, null, null);
	}

	private StringBuffer createHttpHeadURL() {
		if (this.sb != null) {
			return this.sb;
		}
		this.sb = new StringBuffer();
		this.sb.append(this.serverURL);
		this.sb.append("?corp_id=");
		this.sb.append(this.corpID);
		this.sb.append("&corp_pwd=");
		this.sb.append(this.corpPWD);
		this.sb.append("&corp_service=");
		this.sb.append(this.corpService);
		return this.sb;
	}

	public static String utf2Other(String sourceStr) {
		try {
			String read = UTF8EncodeUtil.readString(sourceStr.getBytes());
			System.out.println(read);
			String tt = UTF8EncodeUtil.u2g(sourceStr);
			System.out.println(new String(tt.getBytes("utf-8")));
			byte[] temp = sourceStr.getBytes("gbk");
			byte[] newtemp = new String(temp, "gbk").getBytes("utf-8");
			String newStr = new String(newtemp, "utf-8");
			System.out.println(new String(newStr.getBytes("utf-8")));
			String utf82 = new String(sourceStr.getBytes("gbk"), Charset.forName("utf-8"));
			System.out.println("\u8fd9\u662f\u6253\u5370\u7684\u5b57\u7b26 = " + utf82);
			String unicode2 = new String(utf82.getBytes(), "gbk");
			System.out.println(unicode2);
			String ret = URLDecoder.decode(sourceStr, "utf-8");
			System.out.println("utf-8\u6253\u5370 = " + ret);
			String ret2 = URLDecoder.decode(sourceStr, "gbk");
			System.out.println("gbk\u6253\u5370 = " + ret2);
			String ret3 = new String(ret.getBytes("utf-8"), "gbk");
			System.out.println("gbk333\u6253\u5370 = " + ret3);
			String gbk = new String(unicode2.getBytes("utf-8"));
			System.out.println("result = " + gbk);
			return ret2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getCorpID() {
		return this.corpID;
	}

	public void setCorpID(String corpID) {
		this.corpID = corpID;
	}

	public String getCorpPWD() {
		return this.corpPWD;
	}

	public void setCorpPWD(String corpPWD) {
		this.corpPWD = corpPWD;
	}

	public String getCorpService() {
		return this.corpService;
	}

	public void setCorpService(String corpService) {
		this.corpService = corpService;
	}

	public String getServerURL() {
		return this.serverURL;
	}

	public void setServerURL(String serverURL) {
		this.serverURL = serverURL;
	}
}
