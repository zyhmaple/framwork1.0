/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  org.springframework.context.annotation.Scope
 *  org.springframework.stereotype.Repository
 */
package com.zyh.maple.framework.dao;

import java.util.Hashtable;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope(value = "singleton")
@Repository(value = "baseDao")
public interface BaseDao {
	public Object getObject(String var1, Object var2);

	public List getList(String var1, Object var2);

	public int insertObject(String var1, Object var2);

	public int updateObject(String var1, Object var2);

	public int deleteObject(String var1, Object var2);

	public int insertObject(String var1, Object var2, String var3);

	public int updateObject(String var1, Object var2, String var3);

	public int insertBatch(Hashtable var1);

	public int updateBatch(Hashtable var1);
}
