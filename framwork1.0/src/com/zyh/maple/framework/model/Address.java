/*
 * Decompiled with CFR 0_123.
 */
package com.zyh.maple.framework.model;

public class Address {
    private String id;
    private String name;

    public Address(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

