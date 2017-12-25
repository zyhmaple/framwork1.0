/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.framework.model;

public class CacheModel {
    private String statementID;
    private String primaryKeyID;

    public String getStatementID() {
        return this.statementID;
    }

    public void setStatementID(String statementID) {
        this.statementID = statementID;
    }

    public String getPrimaryKeyID() {
        return this.primaryKeyID;
    }

    public void setPrimaryKeyID(String primaryKeyID) {
        this.primaryKeyID = primaryKeyID;
    }
}

