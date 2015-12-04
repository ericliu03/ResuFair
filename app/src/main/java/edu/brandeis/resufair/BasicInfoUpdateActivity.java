package edu.brandeis.resufair;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by wang on 2015/12/4.
 */
public class BasicInfoUpdateActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_info_update);
        // KEY IS LOGENTRY
    }

//    public void

    public void saveNewEntry(View view){
        EditText lastName = (EditText) findViewById(R.id.new_last_name);
        EditText firstName = (EditText) findViewById(R.id.new_first_name);
        EditText summary = (EditText) findViewById(R.id.new_summary);
        Log.d("lastname: ",lastName.toString());
        Log.d("firstname: ",firstName.toString());
        Log.d("summary: ",summary.toString());

//        Intent data = new Intent();

//        data.putExtra("logentry",
//                new com.example.wang.xinyuewanghw3.ExpenseLogEntryData(expense.getText().toString(), notes.getText().toString()));
//        setResult(Activity.RESULT_OK, data);
        finish();
    }

    public void cancelAddEntry(View view){
        finish();
    }
}
