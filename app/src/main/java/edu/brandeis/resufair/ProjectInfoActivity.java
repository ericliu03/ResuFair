package edu.brandeis.resufair;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang on 2015/12/4.
 */
public class ProjectInfoActivity extends AppCompatActivity {
    private ListView projectlv;
    private projectInfoAdapter projectInfoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_listshow);
//        getSupportActionBar().setTitle("Back");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String title1 = "SDE", title2 = "Test";
        String descriptionexp1 = "abc", descriptionexp2 = "ddeeef", start3 = "2005/8/24", end3 = "2007/6/1";
        String start4 = "2007/8/24", end4 = "2010/6/1";
        List<projectInfo> proDataList = new ArrayList<>();
        String title3 = "project1", title4 = "project2", proDescription = "develop", proDescription2 = "test";
        projectInfo info5 = new projectInfo(title3, proDescription, start3, start4);
        projectInfo info6 = new projectInfo(title4, proDescription2, start3, start4);
        proDataList.add(info5);
        proDataList.add(info6);
        projectlv = (ListView) findViewById(R.id.project_info);
        projectInfoAdapter = new projectInfoAdapter(this, R.layout.basic_project_info_entry, proDataList);
        projectlv.setAdapter(projectInfoAdapter);
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
