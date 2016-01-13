package com.xinyi.duan.drugstore;

/**
 * Created by Duan on 2016/1/12.
 */
public interface Database {
    public void add(Drug drug);
    public String query(String msg);
    public void delete(Drug drug);
}
