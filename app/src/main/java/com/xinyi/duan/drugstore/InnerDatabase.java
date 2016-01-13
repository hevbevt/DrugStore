package com.xinyi.duan.drugstore;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Duan on 2016/1/12.
 */
public class InnerDatabase implements Database {
    private static InnerDatabase uniqueInstance;
    private SQLiteHelper dbHelper = new SQLiteHelper(
            MyApplication.getContext(), "DrugStore.db", null, 1);

    private InnerDatabase() {

    }

    public static InnerDatabase getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new InnerDatabase();
        }
        return uniqueInstance;
    }

    @Override
    public void add(Drug drug) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", drug.getName());
        values.put("standard", drug.getStandard());
        values.put("drug_id", drug.getId());
        db.insert("Drug", null, values);
        db.close();
    }

    @Override
    public String query(String msg) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("Drug", null, null, null, null, null, null);
        StringBuilder stringBuilder = new StringBuilder();
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String standard = cursor.getString(cursor.getColumnIndex("standard"));
                String id = cursor.getString(cursor.getColumnIndex("drug_id"));
                if (name.contains(msg) || id.contains(msg))
                    stringBuilder.append("药品名称:" + name + "\n药品规格:\n" + standard
                            + "\n药品编号:" + id + "\n");
            } while (cursor.moveToNext());
        }
        cursor.close();
        return stringBuilder.toString();
    }

    @Override
    public void delete(Drug drug) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("Drug", "name = ", new String[]{drug.getName()});
    }
}
