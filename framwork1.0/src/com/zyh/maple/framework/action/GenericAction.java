/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  com.opensymphony.xwork2.ActionSupport
 *  javax.servlet.RequestDispatcher
 *  javax.servlet.ServletContext
 *  javax.servlet.http.Cookie
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  org.apache.struts2.ServletActionContext
 */
package com.zyh.maple.framework.action;

import java.io.File;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zyh.maple.framework.commons.SysParams;
import com.zyh.maple.framework.util.ImageProcessor;

public class GenericAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final Logger log = Logger.getLogger(GenericAction.class);
	private String totalRecords = null;
	private String cPageNo = null;
	private String pageRecords = null;
	private String basePathHavePort = null;
	private String basePathNotPort = null;
	private int imageNewWidth = 0;
	private int imgageNewHeight = 0;
	private int imageCoordinateX = 0;
	private int imageCoordinateY = 0;
	private String imageUrl = null;
	private String userName = null;
	private String shareContent = null;
	private String shareDesc = null;
	private String shareURL = null;
	private String sharePic = null;

	public String getCookieUserID() {
		return this.getCookie("userID");
	}

	public String getCookiePassword() {
		return this.getCookie("userPassword");
	}

	public String getCookieCheck() {
		return this.getCookie("userCheck");
	}

	public String getCookie(String cookieStr) {
		String resStr = null;
		Cookie[] cs = this.getRequest().getCookies();
		if (cs != null) {
			int i = 0;
			while (i < cs.length) {
				if (cs[i].getName().equalsIgnoreCase(cookieStr)) {
					resStr = cs[i].getValue();
					break;
				}
				++i;
			}
		}
		return resStr;
	}

	public void memberLogin(String memberID, String cinemaID) {
		if (memberID != null) {
			this.getSession().setAttribute("memberID", (Object) memberID);
		}
		if (cinemaID != null) {
			this.getSession().setAttribute("cinemaID", (Object) cinemaID);
		}
	}

	public String getSessionMemberID() throws Exception {
		return (String) this.getSession().getAttribute("memberID");
	}

	public String getSessionCinemaID() throws Exception {
		return (String) this.getSession().getAttribute("cinemaID");
	}

	public String getSessionMemberName() throws Exception {
		return (String) this.getSession().getAttribute("SPRING_SECURITY_LAST_USERNAME");
	}

	protected void userLogin(String memberID, String password, String userName, String check) {
		System.out.println("2222check = " + check);
		this.getSession().setAttribute("memberID", (Object) memberID);
		this.getSession().setAttribute("userID", (Object) memberID);
		this.getSession().setAttribute("userName", (Object) userName);
		if (check == null) {
			return;
		}
		boolean isCookie = true;
		Cookie[] cs = this.getRequest().getCookies();
		if (cs != null) {
			int i = 0;
			while (i < cs.length) {
				if (cs[i].getName().equalsIgnoreCase("userID")) {
					if (this.getCookieCheck() == null)
						break;
					isCookie = false;
					break;
				}
				++i;
			}
		}
		if (isCookie && memberID != null && !memberID.equals("")) {
			Cookie namecookie = new Cookie("userID", memberID);
			namecookie.setMaxAge(31536000);
			this.getResponse().addCookie(namecookie);
			Cookie passwordcookie = new Cookie("userPassword", password);
			passwordcookie.setMaxAge(31536000);
			this.getResponse().addCookie(passwordcookie);
			Cookie checkcookie = new Cookie("userCheck", check);
			checkcookie.setMaxAge(31536000);
			this.getResponse().addCookie(checkcookie);
		}
	}

	public void clearCookie() {
		Cookie[] cookies = this.getRequest().getCookies();
		try {
			int i = 0;
			while (i < cookies.length) {
				Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setMaxAge(0);
				this.getResponse().addCookie(cookie);
				++i;
			}
		} catch (Exception ex) {
			System.out.println("\u6e05\u7a7aCookies\u53d1\u751f\u5f02\u5e38\uff01");
		}
	}

	public void saveImage(String imgOriginalPath, String imgDestPath) throws Exception {
		ImageProcessor.copyImage(imgOriginalPath, imgDestPath);
		ImageProcessor.cutImage(imgOriginalPath, imgOriginalPath, "jpg", this.imageCoordinateX, this.imageCoordinateY,
				this.imageNewWidth, this.imgageNewHeight);
		File tempfile = new File(imgOriginalPath);
		String fileName = tempfile.getName();
		int i = 0;
		while (i < SysParams.IMAGECUTSIZE.length) {
			if (i != 1) {
				String imgDestPathTemp = String.valueOf(imgDestPath) + "/" + SysParams.IMAGESAVEPATH[i] + "/";
				File dicfile = new File(imgDestPathTemp);
				if (!dicfile.exists()) {
					dicfile.mkdirs();
				}
				imgDestPathTemp = String.valueOf(imgDestPathTemp) + fileName;
				ImageProcessor.scaledImage(imgOriginalPath, imgDestPathTemp, SysParams.IMAGECUTSIZE[i],
						SysParams.IMAGECUTSIZE[i], "jpg");
			}
			++i;
		}
	}

	public void scaledOriginalImage(String imgOriginalPath) throws Exception {
		ImageProcessor.initImage(imgOriginalPath);
	}

	protected String getOnlineMemberNum() {
		return (String) this.getSession().getServletContext().getAttribute("onlineUserNum");
	}

	public String getMemberID() {
		String memberid_session = (String) this.getSession().getAttribute("memberID");
		if (memberid_session == null) {
			memberid_session = "";
		}
		return memberid_session;
	}

	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	protected HttpSession getSession() {
		return this.getRequest().getSession(true);
	}

	protected RequestDispatcher getRequestDispatcher(String url) {
		return ServletActionContext.getServletContext().getRequestDispatcher(url);
	}

	protected void logInfo(String message) {
		this.log.info(message);
	}

	protected void logError(String message) {
		this.log.error(message);
	}

	protected void logDebug(String message) {
		this.log.debug(message);
	}

	protected Logger getLog() {
		return this.log;
	}

	public String getTotalRecords() {
		return this.totalRecords;
	}

	public void setTotalRecords(String totalRecords) {
		this.getRequest().setAttribute("total", (Object) totalRecords);
		this.totalRecords = totalRecords;
	}

	public String getCPageNo() {
		return this.cPageNo;
	}

	public void setCPageNo(String pageNo) {
		this.cPageNo = pageNo;
	}

	public String getPageRecords() {
		return this.pageRecords;
	}

	public void setPageRecords(String pageRecords) {
		this.pageRecords = pageRecords;
	}

	public int getImageNewWidth() {
		return this.imageNewWidth;
	}

	public void setImageNewWidth(int imageNewWidth) {
		this.imageNewWidth = imageNewWidth;
	}

	public int getImgageNewHeight() {
		return this.imgageNewHeight;
	}

	public void setImgageNewHeight(int imgageNewHeight) {
		this.imgageNewHeight = imgageNewHeight;
	}

	public int getImageCoordinateX() {
		return this.imageCoordinateX;
	}

	public void setImageCoordinateX(int imageCoordinateX) {
		this.imageCoordinateX = imageCoordinateX;
	}

	public int getImageCoordinateY() {
		return this.imageCoordinateY;
	}

	public void setImageCoordinateY(int imageCoordinateY) {
		this.imageCoordinateY = imageCoordinateY;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getUserName() {
		this.userName = (String) this.getSession().getAttribute("userName");
		if (this.userName == null) {
			this.userName = "";
		}
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShareContent() {
		return this.shareContent;
	}

	public void setShareContent(String shareContent) {
		this.shareContent = shareContent;
	}

	public String getShareDesc() {
		return this.shareDesc;
	}

	public void setShareDesc(String shareDesc) {
		this.shareDesc = shareDesc;
	}

	public String getShareURL() {
		return this.shareURL;
	}

	public void setShareURL(String shareURL) {
		this.shareURL = shareURL;
	}

	public String getSharePic() {
		return this.sharePic;
	}

	public void setSharePic(String sharePic) {
		this.sharePic = sharePic;
	}
}
