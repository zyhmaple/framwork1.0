/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  org.springframework.security.access.AccessDecisionManager
 *  org.springframework.security.access.AccessDeniedException
 *  org.springframework.security.access.ConfigAttribute
 *  org.springframework.security.authentication.InsufficientAuthenticationException
 *  org.springframework.security.core.Authentication
 *  org.springframework.security.core.GrantedAuthority
 */
package com.zyh.maple.framework.security;

import java.nio.file.AccessDeniedException;
import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class MyAccessDecisionManager implements AccessDecisionManager {
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws InsufficientAuthenticationException {
		if (configAttributes == null) {
			return;
		}
		for (ConfigAttribute configAttribute : configAttributes) {
			String needPermission = configAttribute.getAttribute();
			System.out.println("needPermission is " + needPermission);
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				System.out.println("yourPermission is " + ga.getAuthority());
				if (!needPermission.equals(ga.getAuthority()))
					continue;
				return;
			}
		}

		try {
			throw new AccessDeniedException("\u4f60\u6ca1\u6709\u8bbf\u95ee\u8be5\u9875\u9762\u7684\u6743\u9650!");
		} catch (AccessDeniedException e) {
			e.printStackTrace();
		}

	}

	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}
}
