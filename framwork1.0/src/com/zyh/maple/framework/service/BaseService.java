/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.framework.service;

import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope(value = "singleton")
@Service(value = "baseService")
public interface BaseService {
	public Object getObject(String var1, Object var2) throws Exception;

	public List getList(String var1, Object var2) throws Exception;

	public int updateObject(String var1, Object var2) throws Exception;

	public int deleteObject(String var1, Object var2) throws Exception;

	public int insertObject(String var1, Object var2, Set<String> var3) throws Exception;

	public int updateObject(String var1, Object var2, Set<String> var3) throws Exception;

	public int insertObject(String var1, Object var2) throws Exception;

	public Object getObject(String var1, Object var2, String var3) throws Exception;

	public List getList(String var1, Object var2, String var3) throws Exception;

	public int updateMultiDataSourceObject(String var1, Object var2, String var3) throws Exception;

	public int deleteObject(String var1, Object var2, String var3) throws Exception;

	public int insertObject(String var1, Object var2, Set<String> var3, String var4) throws Exception;

	public int updateObject(String var1, Object var2, Set<String> var3, String var4) throws Exception;

	public int insertMultiDataSourceObject(String var1, Object var2, String var3) throws Exception;
}
