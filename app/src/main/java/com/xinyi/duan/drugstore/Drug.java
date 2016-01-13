package com.xinyi.duan.drugstore;

/**
 * Created by Duan on 2016/1/12.
 */
public class Drug {
    String name;
    String standard;
    String id;

    public Drug(String name, String standard, String id) {
        this.name = name;
        this.standard = standard;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getStandard() {
        return standard;
    }

    public String getId() {
        return id;
    }
}
