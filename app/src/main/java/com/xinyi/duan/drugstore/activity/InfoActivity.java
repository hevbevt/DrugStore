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
        nameTv.setText(drug.getName());
        standardTv.setText(drug.getStandard());
        idTv.setText(drug.getId());
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
