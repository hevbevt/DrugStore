package com.xinyi.duan.drugstore.db;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import com.xinyi.duan.drugstore.model.Drug;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duan on 2016/1/15.
 */
public class NetDatabase extends AsyncTask<Void, Integer, List<Drug>>{

    private static NetDatabase uniqueInstance;
    private static List<Drug> list;

    static final String JDBC_DRIVER = "com.mysql.jdbc.driver";
    static final String DB_URL =
            "jdbc:mysql://qiexiongdrugs.mysql.rds.aliyuncs.com:3306/testdb";
    static final String USER = "hevbevt";
    static final String PASS = "335351";
    static final String TABLE_NAME = "test_drug";
    static final String TAG = "DATABASE_CONNECTION";

    public Connection conn = null;
    public Statement stmt = null;

    @Override
    protected List<Drug> doInBackground(Void... params) {
        List<Drug> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.driver");
            Log.d(TAG, "NetDatabase: Connecting Database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Log.d(TAG, "NetDatabase: Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name, drug_id, specifications FROM test_drug";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                String specifications = rs.getString("specifications");
                String drugId = rs.getString("drug_id");
                Drug drug = new Drug(name, specifications, drugId);
                Log.d(TAG, name);
                Log.d(TAG, specifications);
                Log.d(TAG, drugId);
                list.add(drug);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void onPostExecute(List<Drug> drugs) {
        this.list = drugs;
    }




    public static List<Drug> query(String msg) {
        List<Drug> queryList = new ArrayList<>();
        for (Drug drug : list) {
            if (drug.getName().contains(msg)){
                queryList.add(drug);
            }
        }
        return queryList;
    }

}
