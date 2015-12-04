package edu.brandeis.resufair;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
public class ExpInfoActivity extends AppCompatActivity {
    private ListView explv;
    private expInfoAdapter expInfoAdapter;
    private ServerAPI server;
    private expInfo info;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp_listshow);
        server = ServerAPI.getInstance(this);
        explv = (ListView) findViewById(R.id.exp_info);
        getExpInfo();
    }

    private void getExpInfo() {
        server.getCandidate(new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                info = new expInfo(response);
                List<expInfo> expDataList = info.getInfo();
                expInfoAdapter = new expInfoAdapter(ExpInfoActivity.this, R.layout.basic_exp_info_entry, expDataList);
                explv.setAdapter(expInfoAdapter);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ExpInfoActivity.this, "Something wrong, try again", Toast.LENGTH_LONG).show();

            }
        });

    }
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

}
