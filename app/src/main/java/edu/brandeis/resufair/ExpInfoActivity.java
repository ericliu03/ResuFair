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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp_listshow);
//        getSupportActionBar().setTitle("Back");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<expInfo> expDataList = new ArrayList<>();
        String title1 = "SDE", title2 = "Test";
        String descriptionexp1 = "abc", descriptionexp2 = "ddeeef", start3 = "2005/8/24", end3 = "2007/6/1";
        String start4 = "2007/8/24", end4 = "2010/6/1";
//        expInfo info3 = new expInfo(title1, descriptionexp1, start3, end3);
//        expInfo info4 = new expInfo(title2, descriptionexp2, start4, end4);
//        expDataList.add(info3);
//        expDataList.add(info4);
        explv = (ListView) findViewById(R.id.exp_info);
        expInfoAdapter = new expInfoAdapter(this, R.layout.basic_exp_info_entry, expDataList);
        explv.setAdapter(expInfoAdapter);
    }

    private void getExpInfo() {
        server.getCandidate(new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                info = new expInfo(response);
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
