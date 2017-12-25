/*
 * Restructured by zyhmaple
 * 2017.12.25
 */
package com.zyh.maple.framework.dao.mybatis;

public class StringEscape {
    public static String escape(String input) {
        String output = input;
        output = output.replaceAll("<", "&lt;");
        output = output.replaceAll(">", "&gt;");
        output = output.replaceAll("\"", "&quot;");
        output = output.replaceAll("'", "&#39;");
        return output;
    }
}

