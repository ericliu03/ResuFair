package edu.brandeis.resufair;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by wang on 2015/12/4.
 */
public class infoOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_options);
//        getSupportActionBar().setTitle("Back");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void ShowBasic(View view){
//        EditText expense = (EditText) findViewById(R.id.new_expense);
//        EditText notes = (EditText) findViewById(R.id.new_notes);
//        Intent data = new Intent();
//        data.putExtra("logentry",
//                new com.example.wang.xinyuewanghw3.ExpenseLogEntryData(expense.getText().toString(), notes.getText().toString()));
//        setResult(Activity.RESULT_OK, data);
        Intent intent = new Intent(this, BasicInfoActivity.class);
        startActivity(intent);
    }
    public void ShowEducation(View view){
//        EditText expense = (EditText) findViewById(R.id.new_expense);
//        EditText notes = (EditText) findViewById(R.id.new_notes);
//        Intent data = new Intent();
//        data.putExtra("logentry",
//                new com.example.wang.xinyuewanghw3.ExpenseLogEntryData(expense.getText().toString(), notes.getText().toString()));
//        setResult(Activity.RESULT_OK, data);
        Intent intent = new Intent(this, EduInfoActivity.class);
        startActivity(intent);
    }
    public void ShowExperience(View view){
//        EditText expense = (EditText) findViewById(R.id.new_expense);
//        EditText notes = (EditText) findViewById(R.id.new_notes);
//        Intent data = new Intent();
//        data.putExtra("logentry",
//                new com.example.wang.xinyuewanghw3.ExpenseLogEntryData(expense.getText().toString(), notes.getText().toString()));
//        setResult(Activity.RESULT_OK, data);
        Intent intent = new Intent(this, ExpInfoActivity.class);
        startActivity(intent);
    }
    public void ShowProject(View view){
//        EditText expense = (EditText) findViewById(R.id.new_expense);
//        EditText notes = (EditText) findViewById(R.id.new_notes);
//        Intent data = new Intent();
//        data.putExtra("logentry",
//                new com.example.wang.xinyuewanghw3.ExpenseLogEntryData(expense.getText().toString(), notes.getText().toString()));
//        setResult(Activity.RESULT_OK, data);
        Intent intent = new Intent(this, ProjectInfoActivity.class);
        startActivity(intent);
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
