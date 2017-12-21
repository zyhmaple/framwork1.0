/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  org.springframework.context.annotation.Scope
 *  org.springframework.stereotype.Service
 */
package com.zyh.maple.framework.service;

import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope(value="singleton")
@Service(value="baseService")
public interface BaseService {
    public Object getObject(String var1, Object var2) throws Exception;

    public List getList(String var1, Object var2) throws Exception;

    public int updateObject(String var1, Object var2) throws Exception;

    public int deleteObject(String var1, Object var2) throws Exception;

    public int insertObject(String var1, Object var2, String var3) throws Exception;

    public int updateObject(String var1, Object var2, String var3) throws Exception;

    public int insertObject(String var1, Object var2) throws Exception;

    public Object getObject(String var1, Object var2, String var3) throws Exception;

    public List getList(String var1, Object var2, String var3) throws Exception;

    public int updateMultiDataSourceObject(String var1, Object var2, String var3) throws Exception;

    public int deleteObject(String var1, Object var2, String var3) throws Exception;

    public int insertObject(String var1, Object var2, String var3, String var4) throws Exception;

    public int updateObject(String var1, Object var2, String var3, String var4) throws Exception;

    public int insertMultiDataSourceObject(String var1, Object var2, String var3) throws Exception;
}

