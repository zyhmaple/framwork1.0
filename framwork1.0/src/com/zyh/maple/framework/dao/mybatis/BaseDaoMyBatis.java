/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.framework.dao.mybatis;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.zyh.maple.framework.dao.BaseDao;

@Scope(value="singleton")
@Repository(value="baseDaoMyBatis")
public class BaseDaoMyBatis
implements BaseDao {
    protected final Log log;
    @Autowired
    private SqlSessionTemplate sqlSession;

    public BaseDaoMyBatis() {
        this.log = LogFactory.getLog(this.getClass());
        this.sqlSession = null;
    }

    @Override
    public Object getObject(String queryname, Object param) {
        System.out.println("sqlSession = " + this.sqlSession);
        if (param == null) {
            return this.sqlSession.selectOne(queryname);
        }
        return this.sqlSession.selectOne(queryname, param);
    }

    @Override
    public List getList(String queryname, Object param) {
        if (param == null) {
            return this.sqlSession.selectList(queryname);
        }
        return this.sqlSession.selectList(queryname, param);
    }

    @Override
    public int insertObject(String sqlname, Object param, Set<String> unEscapeFieldName) {
        EntityEscape.escape(param, unEscapeFieldName);
        return this.sqlSession.insert(sqlname, param);
    }

    @Override
    public int insertObject(String sqlname, Object param) {
        EntityEscape.escape(param);
        return this.sqlSession.insert(sqlname, param);
    }

    @Override
    public int updateObject(String sqlname, Object param, Set<String> unEscapeFieldName) {
        EntityEscape.escape(param, unEscapeFieldName);
        return this.sqlSession.update(sqlname, param);
    }

    @Override
    public int updateObject(String sqlname, Object param) {
        EntityEscape.escape(param);
        return this.sqlSession.update(sqlname, param);
    }

    @Override
    public int deleteObject(String sqlname, Object param) {
        if (param == null) {
            return this.sqlSession.delete(sqlname);
        }
        return this.sqlSession.delete(sqlname, param);
    }

    @Override
    public int insertBatch(Hashtable batchHash) {
        return 0;
    }

    @Override
    public int updateBatch(Hashtable batchHash) {
        return 0;
    }
}

