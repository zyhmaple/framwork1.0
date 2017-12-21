/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.dao.mybatis;

import java.lang.reflect.Method;

public class EntityEscape {
    public static void escape(Object obj) {
        Method[] methodArray = obj.getClass().getMethods();
        int i = 0;
        while (i < methodArray.length) {
            Method method = methodArray[i];
            if (method.getName().substring(0, 3).equals("get") && !method.getName().equals("getClass")) {
                String funcName = method.getName().replaceFirst("g", "s");
                Method m = null;
                try {
                    m = obj.getClass().getMethod(funcName, method.getReturnType());
                    String forEscapeString = "";
                    if (method.getReturnType().equals(String.class)) {
                        forEscapeString = (String)method.invoke(obj, new Object[0]);
                    }
                    if (forEscapeString != null && forEscapeString.length() != 0) {
                        forEscapeString = StringEscape.escape(forEscapeString);
                        m.invoke(obj, forEscapeString);
                    }
                }
                catch (Exception forEscapeString) {
                    // empty catch block
                }
            }
            ++i;
        }
    }

    public static void escape(Object obj, String unEscapeFieldName) {
        if (unEscapeFieldName != null && unEscapeFieldName.length() > 0) {
            String firstChar = unEscapeFieldName.substring(0, 1).toUpperCase();
            unEscapeFieldName = "get" + firstChar + unEscapeFieldName.substring(1);
        }
        Method[] methodArray = obj.getClass().getMethods();
        int i = 0;
        while (i < methodArray.length) {
            Method method = methodArray[i];
            if (!(!method.getName().substring(0, 3).equals("get") || method.getName().equals("getClass") || unEscapeFieldName != null && method.getName().equals(unEscapeFieldName))) {
                String funcName = method.getName().replaceFirst("g", "s");
                Method m = null;
                try {
                    m = obj.getClass().getMethod(funcName, method.getReturnType());
                    String forEscapeString = "";
                    if (method.getReturnType().equals(String.class)) {
                        forEscapeString = (String)method.invoke(obj, new Object[0]);
                    }
                    if (forEscapeString != null && forEscapeString.length() != 0) {
                        forEscapeString = StringEscape.escape(forEscapeString);
                        m.invoke(obj, forEscapeString);
                    }
                }
                catch (Exception forEscapeString) {
                    // empty catch block
                }
            }
            ++i;
        }
    }
}

