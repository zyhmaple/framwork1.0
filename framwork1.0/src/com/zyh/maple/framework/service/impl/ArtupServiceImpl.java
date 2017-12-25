/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.framework.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zyh.maple.framework.commons.Pager;
import com.zyh.maple.framework.dao.BaseDao;
import com.zyh.maple.framework.datasource.DataSourceContextHolder;
import com.zyh.maple.framework.service.BaseService;

@Scope(value="singleton")
@Service(value="artupServiceImpl")
public class ArtupServiceImpl
implements BaseService {
    protected final Log log;
    @Autowired
    @Qualifier(value="baseDaoMyBatis")
    private BaseDao dao;

    public ArtupServiceImpl() {
        this.log = LogFactory.getLog(this.getClass());
        this.dao = null;
    }

    @Override
    public Object getObject(String queryname, Object param) throws Exception {
        return this.dao.getObject(queryname, param);
    }

    @Override
    public List getList(String queryname, Object param) throws Exception {
        return this.dao.getList(queryname, param);
    }

    @Override
    public int updateObject(String sqlname, Object param) throws Exception {
        return this.dao.updateObject(sqlname, param);
    }

    @Override
    public int deleteObject(String sqlname, Object param) throws Exception {
        return this.dao.deleteObject(sqlname, param);
    }

    @Override
    public int insertObject(String sqlname, Object param, Set<String> unEscapeFieldName) throws Exception {
        int insertResult = 0;
        insertResult = this.dao.insertObject(sqlname, param, unEscapeFieldName);
        return insertResult;
    }

    @Override
    public int updateObject(String sqlname, Object param, Set<String> unEscapeFieldName) throws Exception {
        int insertResult = 0;
        insertResult = this.dao.updateObject(sqlname, param, unEscapeFieldName);
        return insertResult;
    }

    @Override
    public int insertObject(String sqlname, Object param) throws Exception {
        int insertResult = 0;
        insertResult = this.dao.insertObject(sqlname, param);
        return insertResult;
    }

    public Pager pagination(List list, int pageSize, String go1) throws Exception {
        int showPage = 1;
        int lastRow = 0;
        int pageCount = 0;
        Pager pager = new Pager();
        lastRow = list.size();
        int n = pageCount = lastRow % pageSize == 0 ? lastRow / pageSize : lastRow / pageSize + 1;
        if (go1 == null) {
            go1 = "1";
        }
        try {
            showPage = Integer.parseInt(go1);
        }
        catch (NumberFormatException e) {
            showPage = 1;
        }
        if (showPage >= pageCount) {
            showPage = pageCount;
        }
        if (showPage <= 1) {
            showPage = 1;
        }
        pager.setCurrentPage(showPage);
        pager.setPageSize(pageSize);
        pager.setTotalPages(pageCount);
        pager.setTotalRows(lastRow);
        int position = (showPage - 1) * pageSize;
        int endposion = showPage * pageSize;
        List listTemp = null;
        listTemp = showPage == lastRow / pageSize + 1 ? list.subList(position, endposion - pageSize + lastRow % pageSize) : list.subList(position, endposion);
        pager.setListData(listTemp);
        return pager;
    }

    @Override
    public Object getObject(String queryname, Object param, String dataSource) throws Exception {
        DataSourceContextHolder.setDataSourceType(dataSource);
        Object object = this.getObject(queryname, param);
        DataSourceContextHolder.clearDataSourceType();
        return object;
    }

    @Override
    public List getList(String queryname, Object param, String dataSource) throws Exception {
        DataSourceContextHolder.setDataSourceType(dataSource);
        List list = this.getList(queryname, param);
        DataSourceContextHolder.clearDataSourceType();
        return list;
    }

    @Override
    public int updateMultiDataSourceObject(String sqlname, Object param, String dataSource) throws Exception {
        DataSourceContextHolder.setDataSourceType(dataSource);
        int list = this.updateObject(sqlname, param);
        DataSourceContextHolder.clearDataSourceType();
        return list;
    }

    @Override
    public int deleteObject(String sqlname, Object param, String dataSource) throws Exception {
        DataSourceContextHolder.setDataSourceType(dataSource);
        int list = this.deleteObject(sqlname, param);
        DataSourceContextHolder.clearDataSourceType();
        return list;
    }

    @Override
    public int insertObject(String sqlname, Object param, Set<String> unEscapeFieldName, String dataSource) throws Exception {
        DataSourceContextHolder.setDataSourceType(dataSource);
        int list = this.insertObject(sqlname, param, unEscapeFieldName);
        DataSourceContextHolder.clearDataSourceType();
        return list;
    }

    @Override
    public int updateObject(String sqlname, Object param, Set<String> unEscapeFieldName, String dataSource) throws Exception {
        DataSourceContextHolder.setDataSourceType(dataSource);
        int list = this.updateObject(sqlname, param, unEscapeFieldName);
        DataSourceContextHolder.clearDataSourceType();
        return list;
    }

    @Override
    public int insertMultiDataSourceObject(String sqlname, Object param, String dataSource) throws Exception {
        DataSourceContextHolder.setDataSourceType(dataSource);
        int list = this.insertObject(sqlname, param);
        DataSourceContextHolder.clearDataSourceType();
        return list;
    }
}

