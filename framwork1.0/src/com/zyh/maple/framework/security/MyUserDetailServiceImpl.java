/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  org.springframework.security.core.GrantedAuthority
 *  org.springframework.security.core.authority.SimpleGrantedAuthority
 *  org.springframework.security.core.userdetails.User
 *  org.springframework.security.core.userdetails.UserDetails
 *  org.springframework.security.core.userdetails.UserDetailsService
 *  org.springframework.security.core.userdetails.UsernameNotFoundException
 */
package com.zyh.maple.framework.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zyh.maple.framework.model.MemberInfo;

public class MyUserDetailServiceImpl
implements UserDetailsService {
    private SqlSessionTemplate sqlSession = null;

    public SqlSessionTemplate getSqlSession() {
        return this.sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberInfo users = (MemberInfo)this.sqlSession.selectOne("org.mybatis.SysMapper.getUserByName", username);
        Set<GrantedAuthority> grantedAuths = this.obtionGrantedAuthorities(users);
        User userdetail = new User(users.getMemberName(), users.getPassword(), true, true, true, true, grantedAuths);
        return userdetail;
    }

    private Set<GrantedAuthority> obtionGrantedAuthorities(MemberInfo user) {
        List<String> resources = this.sqlSession.selectList("org.mybatis.SysMapper.getAllRoleByUserID", user.getMemberID());
        HashSet<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
        for (String rightName : resources) {
            System.out.println("res.getResourceName() = " + rightName);
            authSet.add((GrantedAuthority)new SimpleGrantedAuthority("ROLE_" + rightName));
        }
        return authSet;
    }
}

