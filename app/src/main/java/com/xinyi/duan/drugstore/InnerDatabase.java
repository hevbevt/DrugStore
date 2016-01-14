package com.xinyi.duan.drugstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duan on 2016/1/12.
 */
public class InnerDatabase implements Database {
    private static InnerDatabase uniqueInstance;

    private SQLiteDatabase db;

    private InnerDatabase(Context context) {
        SQLiteHelper dbHelper = new SQLiteHelper(
            context, "DrugStore.db", null, 1);
        db = dbHelper.getWritableDatabase();
    }

    public static InnerDatabase getInstance(Context context) {
        if (uniqueInstance == null) {
            uniqueInstance = new InnerDatabase(context);
        }
        return uniqueInstance;
    }

    @Override
    public void add(Drug drug) {
        if (drug != null) {
            ContentValues values = new ContentValues();
            values.put("name", drug.getName());
            values.put("standard", drug.getStandard());
            values.put("drug_id", drug.getId());
            db.insert("Drug", null, values);
        }
        // db.close();
    }

    @Override
    public List<Drug> query(String msg) {
        List<Drug> list = new ArrayList<>();
        Cursor cursor = db.query("Drug", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String standard = cursor.getString(cursor.getColumnIndex("standard"));
                String id = cursor.getString(cursor.getColumnIndex("drug_id"));
                Drug drug = new Drug(name, standard, id);
                if (name.contains(msg) || id.contains(msg)) {
                    list.add(drug);
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    @Override
    public void delete(Drug drug) {
        if (drug != null) {
            db.delete("Drug", "name = ?", new String[]{drug.getName()});
        }
    }
}
