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
public class ProjectInfoActivity extends AppCompatActivity {
    private ListView projectlv;
    private projectInfoAdapter projectInfoAdapter;
    private ServerAPI server;
    private projectInfo info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_listshow);
        server = ServerAPI.getInstance(this);
        projectlv = (ListView) findViewById(R.id.project_info);
        getProjectInfo();
    }

    private void getProjectInfo() {
        server.getCandidate(new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                info = new projectInfo(response);
                List<projectInfo> proDataList = info.getInfo();
                projectInfoAdapter = new projectInfoAdapter(ProjectInfoActivity.this, R.layout.basic_project_info_entry, proDataList);
                projectlv.setAdapter(projectInfoAdapter);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ProjectInfoActivity.this, "Something wrong, try again", Toast.LENGTH_LONG).show();

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
