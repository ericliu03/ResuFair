package edu.brandeis.resufair;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 2015/12/4.
 */
public class EduInfoActivity extends AppCompatActivity {
    private ListView edulv;
    private eduInfoAdapter eduInfoAdapter;
    private ServerAPI server;
    private eduInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edu_listshow);
//        getSupportActionBar().setTitle("Back");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        server = ServerAPI.getInstance(this);
        getEduInfo();
        edulv = (ListView) findViewById(R.id.edu_info);

    }

    private void getEduInfo() {
        server.getCandidate(new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                info = new eduInfo(response);
                List<eduInfo> edudataList = info.getInfo();
                eduInfoAdapter = new eduInfoAdapter(EduInfoActivity.this, R.layout.basic_edu_info_entry, edudataList);
                edulv.setAdapter(eduInfoAdapter);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EduInfoActivity.this, "Something wrong, try again", Toast.LENGTH_LONG).show();

            }
        });

    }
    public void UpdateEduInfo(View view){
        finish();
    }
}
