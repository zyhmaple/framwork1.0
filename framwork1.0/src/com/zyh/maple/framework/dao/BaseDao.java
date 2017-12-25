/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.framework.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

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

	public int insertObject(String var1, Object var2, Set<String> var3);

	public int updateObject(String var1, Object var2, Set<String> var3);

	public int insertBatch(Hashtable var1);

	public int updateBatch(Hashtable var1);
}
