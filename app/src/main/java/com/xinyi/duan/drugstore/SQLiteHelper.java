package com.xinyi.duan.drugstore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Duan on 2015/11/22.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String CREATE_DRUG = "create table Drug ("
            + "id integer primary key autoincrement, "
            + "standard text, "
            + "drug_id text, "
            + "name text)";

    private Context mContext;

    public SQLiteHelper(Context context, String name,
                        SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DRUG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Drug");
        onCreate(db);
    }
}
