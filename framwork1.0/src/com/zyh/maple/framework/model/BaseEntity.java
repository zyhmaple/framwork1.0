/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.model;

import java.util.List;

public class BaseEntity {
    private static final long serialVersionUID = 1;
    private String id;
    private String currentpage;
    private String pagermethod;
    private String pagesize;
    private List clickActionList = null;
    private int startrow;
    private int endrow;
    private String currentColomu;
    private String sortChoose = "asc";

    public String getCurrentColomu() {
        return this.currentColomu;
    }

    public void setCurrentColomu(String currentColomu) {
        this.currentColomu = currentColomu;
    }

    public String getSortChoose() {
        return this.sortChoose;
    }

    public void setSortChoose(String sortChoose) {
        this.sortChoose = sortChoose;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStartrow() {
        return this.startrow;
    }

    public void setStartrow(int startrow) {
        this.startrow = startrow;
    }

    public int getEndrow() {
        if (this.endrow > this.startrow) {
            return this.endrow - this.startrow;
        }
        return this.endrow;
    }

    public void setEndrow(int endrow) {
        this.endrow = endrow;
    }

    public String getCurrentpage() {
        return this.currentpage;
    }

    public void setCurrentpage(String currentpage) {
        this.currentpage = currentpage;
    }

    public String getPagermethod() {
        return this.pagermethod;
    }

    public void setPagermethod(String pagermethod) {
        this.pagermethod = pagermethod;
    }

    public String getPagesize() {
        return this.pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }

    public String getClickAction() {
        if (this.clickActionList == null) {
            return "";
        }
        int length = this.clickActionList.size();
        StringBuffer buffer = new StringBuffer("");
        int i = 0;
        while (i < length) {
            String[] params = (String[])this.clickActionList.get(i);
            if (this.isAction(params[0])) {
                buffer.append("<a href=javascript:" + params[0] + "(\"" + this.getClickID() + "\")>" + params[1] + "</a>&nbsp;&nbsp;");
            }
            ++i;
        }
        return buffer.toString();
    }

    public boolean isAction(String actiontype) {
        return true;
    }

    public void setClickAction(List l) {
        this.clickActionList = l;
    }

    public String getClickID() {
        return this.id;
    }
}

