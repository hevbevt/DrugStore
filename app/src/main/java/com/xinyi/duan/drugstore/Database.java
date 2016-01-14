package com.xinyi.duan.drugstore;

import java.util.List;

/**
 * Created by Duan on 2016/1/12.
 */
public interface Database {
    public void add(Drug drug);
    public List query(String msg);
    public void delete(Drug drug);
}
