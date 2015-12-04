package edu.brandeis.resufair;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wang on 2015/12/3.
 */
public class eduInfoAdapter extends ArrayAdapter<eduInfo> {
    int layoutResourceId;
    Context mContext;
    static class infoHolder{
        TextView school;
        TextView degree;
        TextView major;
        TextView gpa;
        TextView start_date;
        TextView end_date;
        TextView description;
    }

    public int getCount(){
        return super.getCount();
    }

    public eduInfo getItem(int index){
        return super.getItem(index);
    }

    public long getItemId(int index){
        return index;
    }

    public eduInfoAdapter(Context mContext, int layoutResourceId, List<eduInfo> data){
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        infoHolder holder = null;
        //get the view and set the text (item name) and tag (item ID) values
        if (row == null){
            LayoutInflater inflater = ((Activity) super.getContext()).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new infoHolder();
            holder.school = (TextView)row.findViewById(R.id.school);
            holder.degree = (TextView)row.findViewById(R.id.degree);
            holder.major = (TextView)row.findViewById(R.id.major);
            holder.gpa = (TextView)row.findViewById(R.id.gpa);
            holder.start_date = (TextView)row.findViewById(R.id.edu_start_date);
            holder.end_date = (TextView)row.findViewById(R.id.edu_end_date);
            holder.description = (TextView)row.findViewById(R.id.edu_description);
            row.setTag(holder);
        }else{
            holder = (infoHolder)row.getTag();
        }
        eduInfo basicData = this.getItem(position);
        holder.school.setText(basicData.getSchool());
        holder.degree.setText(basicData.getDegree());
        holder.major.setText(basicData.getMajor());
        holder.gpa.setText(String.valueOf(basicData.getGpa()));
        holder.start_date.setText(basicData.getStart_date());
        holder.end_date.setText(basicData.getEnd_date());
        holder.description.setText(basicData.getDescription());
        return row;
    }
}
