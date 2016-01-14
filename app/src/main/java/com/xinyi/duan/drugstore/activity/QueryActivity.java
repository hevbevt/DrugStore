package com.xinyi.duan.drugstore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.xinyi.duan.drugstore.model.Drug;
import com.xinyi.duan.drugstore.db.InnerDatabase;
import com.xinyi.duan.drugstore.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duan on 2016/1/14.
 */
public class QueryActivity extends AppCompatActivity{
    private EditText queryText;
    private Button queryBtn;
    private ListView listView;

    private ArrayAdapter<String> adapter;
    private List<Drug> list;
    private InnerDatabase innerDatabase;
    private List<String> dataList = new ArrayList<>();

    private Button addActivity;
    private Button queryActivity;

    private Drug selectedDrug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.query_activity);
        listView = (ListView) findViewById(R.id.list_view);
        queryText = (EditText) findViewById(R.id.query_text);
        queryBtn = (Button) findViewById(R.id.query_button);

        innerDatabase = InnerDatabase.getInstance(this);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = queryText.getText().toString();
                list = innerDatabase.query(msg);
                if (list.size() > 0) {
                    dataList.clear();
                    for (Drug drug : list) {
                        dataList.add(drug.getName());
                    }
                    adapter.notifyDataSetChanged();
                    listView.setSelection(0);
                } else {
                    Log.d("Query", "Query Failed.");
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedDrug = list.get(position);
                Intent intent = new Intent(QueryActivity.this, InfoActivity.class);
                intent.putExtra("drug_data", selectedDrug);
                startActivity(intent);
            }
        });

    }
}
