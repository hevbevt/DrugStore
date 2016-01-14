package com.xinyi.duan.drugstore.model;

import java.io.Serializable;


public class Drug implements Serializable {
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
