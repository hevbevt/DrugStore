package com.xinyi.duan.drugstore.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinyi.duan.drugstore.R;
import com.xinyi.duan.drugstore.db.InnerDatabase;
import com.xinyi.duan.drugstore.model.Drug;


public class InfoActivity extends AppCompatActivity {
    private TextView nameTv;
    private TextView idTv;
    private TextView standardTv;
    private ImageView picIv;
    private Button deleteBtn;
    private Drug drug;

    private InnerDatabase innerDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.info_activity);
        nameTv = (TextView) findViewById(R.id.info_name);
        idTv = (TextView) findViewById(R.id.info_id);
        standardTv = (TextView) findViewById(R.id.info_standard);
        picIv = (ImageView) findViewById(R.id.info_image);
        deleteBtn = (Button) findViewById(R.id.delete_btn);
        drug = (Drug) getIntent().getSerializableExtra("drug_data");
        innerDatabase = InnerDatabase.getInstance(this);
        //如果药品名称过长，重新设置显示字号大小
        if (drug.getName().length() >= 15) {
            nameTv.setTextSize(16);
            nameTv.setText(drug.getName());
        } else if (drug.getName().length() >= 9 && drug.getName().length() < 15) {
            nameTv.setTextSize(24);
            nameTv.setText(drug.getName());
        } else {
            nameTv.setTextSize(40);
            nameTv.setText(drug.getName());
        }
        //设置规格和id
        standardTv.setText(drug.getStandard());
        idTv.setText(drug.getId());
        //删除按钮功能实现。
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drug != null) {
                    innerDatabase.delete(drug);
                }
                finish();
            }
        });

    }
}
