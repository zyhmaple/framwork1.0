/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.springframework.security.access.ConfigAttribute
 *  org.springframework.security.access.SecurityConfig
 *  org.springframework.security.web.FilterInvocation
 *  org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource
 *  org.springframework.security.web.util.AntPathRequestMatcher
 */
package com.zyh.maple.framework.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;

import com.zyh.maple.framework.model.Resources;

public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	private SqlSessionTemplate sqlSession = null;
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public MySecurityMetadataSource(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
		System.out.println("sqlSession = " + sqlSession);
		this.loadResourceDefine();
	}

	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		int firstQuestionMarkIndex;
		String url;
		if (resourceMap == null) {
			this.loadResourceDefine();
		}
		if ((firstQuestionMarkIndex = (url = ((FilterInvocation) object).getRequestUrl()).indexOf("?")) != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}
		System.out.println("requestUrl is " + url);
		HttpServletRequest request = ((FilterInvocation) object).getRequest();
		for (String resURL : resourceMap.keySet()) {
			AntPathRequestMatcher urlMatcher = new AntPathRequestMatcher(resURL);
			if (!urlMatcher.matches(request))
				continue;
			return resourceMap.get(resURL);
		}
		return null;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	private void loadResourceDefine() {
		System.out.println("\u52a0\u8f7d\u6570\u636e\u4e2dwwwwwwwwwwwwwwwwwwwwwwwww");
		if (resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			try {
				System.out.println(this.sqlSession.getConfiguration().getDatabaseId());
				List<Resources> resources = this.sqlSession.selectList("org.mybatis.SysMapper.getAllAuthority");
				System.out.println("resources =" + resources);
				for (Resources resource : resources) {
					Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
					ConfigAttribute configAttribute = new SecurityConfig("ROLE_" + resource.getResourceName());
					configAttributes.add(configAttribute);
					resourceMap.put(resource.getResourceURL(), configAttributes);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
