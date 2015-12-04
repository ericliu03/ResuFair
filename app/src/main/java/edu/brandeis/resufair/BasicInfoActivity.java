package edu.brandeis.resufair;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BasicInfoActivity extends AppCompatActivity {
    private ListView basicInfolv;
    private basicInfoAdapter basicInfoAdapter;
    private ServerAPI server;
    private basicInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basicinfo_listshow);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Back");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        server = ServerAPI.getInstance(this);
        basicInfolv = (ListView) findViewById(R.id.basic_info);

        getBasicInfo();

    }

    private void getBasicInfo() {
        server.getCandidate(new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                info = new basicInfo(response);
                List<basicInfo> basicdataList = new ArrayList<>();
                basicdataList.add(info);
                basicInfoAdapter = new basicInfoAdapter(BasicInfoActivity.this, R.layout.basic_info_entry,basicdataList);
                basicInfolv.setAdapter(basicInfoAdapter);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BasicInfoActivity.this, "Something wrong, try again", Toast.LENGTH_LONG).show();

            }
        });

    }
    public void UpdateBasicInfo(View view){
//        EditText expense = (EditText) findViewById(R.id.new_expense);
//        EditText notes = (EditText) findViewById(R.id.new_notes);
//        Intent data = new Intent();
//        data.putExtra("logentry",
//                new com.example.wang.xinyuewanghw3.ExpenseLogEntryData(expense.getText().toString(), notes.getText().toString()));
//        setResult(Activity.RESULT_OK, data);
        Intent intent = new Intent(this, BasicInfoUpdateActivity.class);
        startActivity(intent);
        finish();
    }


}
