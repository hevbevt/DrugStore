package com.xinyi.duan.drugstore.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xinyi.duan.drugstore.R;
import com.xinyi.duan.drugstore.db.InnerDatabase;
import com.xinyi.duan.drugstore.model.Drug;


public class AddActivity extends AppCompatActivity {
    private EditText nameEt;
    private EditText standardEt;
    private EditText idEt;
    private Button addToLocal;
    private Button addToNet;
    private InnerDatabase innerDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.add_activity);
        nameEt = (EditText) findViewById(R.id.edit_name);
        standardEt = (EditText) findViewById(R.id.edit_standard);
        idEt = (EditText) findViewById(R.id.edit_id);
        addToLocal = (Button) findViewById(R.id.add_indb_btn);
        addToNet = (Button) findViewById(R.id.add_netdb_btn);
        innerDatabase = InnerDatabase.getInstance(this);

        addToLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drug drug;
                String name = nameEt.getText().toString();
                String standard = standardEt.getText().toString();
                String id = idEt.getText().toString();
                //如果输入框内没有内容，则要求重新输入
                if (!name.equals("") && !standard.equals("") && !id.equals("")){
                    drug = new Drug(name, standard, id);
                    innerDatabase.add(drug);
                } else {
                    Toast.makeText(getApplicationContext(), "请输入正确的内容", Toast.LENGTH_SHORT).show();
                }
                nameEt.setText("");
                standardEt.setText("");
                idEt.setText("");
            }
        });
    }
}
