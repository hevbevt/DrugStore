package com.xinyi.duan.drugstore.db;

import com.xinyi.duan.drugstore.model.Drug;

import java.util.List;


public interface Database {
    void add(Drug drug);
    List query(String msg);
    void delete(Drug drug);
}
