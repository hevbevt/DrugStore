package com.xinyi.duan.drugstore;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.xinyi.duan.drugstore.activity.AddActivity;
import com.xinyi.duan.drugstore.activity.QueryActivity;

/**
 * Created by Duan on 2016/1/14.
 */
public class DockLayout extends LinearLayoutCompat {

    public DockLayout(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.dock, this);
        Button queryActivity = (Button) findViewById(R.id.query_activity);
        Button addActivity = (Button) findViewById(R.id.add_activity);
        queryActivity.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), QueryActivity.class);
                getContext().startActivity(intent);
            }
        });
        addActivity.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddActivity.class);
                getContext().startActivity(intent);
            }
        });
    }
}
