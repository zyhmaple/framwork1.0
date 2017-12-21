/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  org.springframework.security.authentication.AuthenticationManager
 *  org.springframework.security.authentication.AuthenticationServiceException
 *  org.springframework.security.authentication.BadCredentialsException
 *  org.springframework.security.authentication.UsernamePasswordAuthenticationToken
 *  org.springframework.security.core.Authentication
 *  org.springframework.security.core.AuthenticationException
 *  org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
 */
package com.zyh.maple.framework.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.zyh.maple.framework.model.MemberInfo;

public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private static final String USERNAME = "userName";
	private static final String PASSWORD = "password";
	private SqlSessionTemplate sqlSession = null;

	public SqlSessionTemplate getSqlSession() {
		return this.sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		String username = this.obtainUsername(request);
		String password = this.obtainPassword(request);
		MemberInfo users = (MemberInfo) this.sqlSession.selectOne("org.mybatis.SysMapper.getUserByName",
				username = username.trim());
		if (users == null || !users.getPassword().equals(password)) {
			throw new BadCredentialsException(
					"\u767b\u5f55\u8d26\u53f7\u6216\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165!");
		}
		request.getSession().setAttribute("memberID", (Object) users.getMemberID());
		request.getSession().setAttribute("cinemaID", (Object) users.getEnabled());
		request.getSession().setAttribute("SPRING_SECURITY_LAST_USERNAME", (Object) username);
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken((Object) username,
				(Object) password);
		this.setDetails(request, authRequest);
		return getAuthenticationManager().authenticate((Authentication) authRequest);
	}

	protected String obtainUsername(HttpServletRequest request) {
		String obj = request.getParameter("userName");
		return obj == null ? "" : obj.toString();
	}

	protected String obtainPassword(HttpServletRequest request) {
		String obj = request.getParameter("password");
		return obj == null ? "" : obj.toString();
	}

	protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
		super.setDetails(request, authRequest);
	}
}
