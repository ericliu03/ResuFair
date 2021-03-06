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
public class projectInfoAdapter extends ArrayAdapter<projectInfo>{
    int layoutResourceId;
    static class infoHolder{
        TextView title;
        TextView description;
        TextView start_date;
        TextView end_date;
    }

    public projectInfoAdapter(Context mContext, int layoutResourceId, List<projectInfo> data){
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
    }
    public int getCount(){
        return super.getCount();
    }

    public projectInfo getItem(int index){
        return super.getItem(index);
    }

    public long getItemId(int index){
        return index;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        infoHolder holder = null;
        //get the view and set the text (item name) and tag (item ID) values
        if (row == null){
            LayoutInflater inflater = ((Activity) super.getContext()).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new infoHolder();
            holder.title = (TextView)row.findViewById(R.id.pro_title);
            holder.start_date = (TextView)row.findViewById(R.id.pro_start_date);
            holder.end_date = (TextView)row.findViewById(R.id.pro_end_date);
            holder.description = (TextView)row.findViewById(R.id.pro_description);
            row.setTag(holder);
        }else{
            holder = (infoHolder)row.getTag();
        }
        projectInfo basicData = this.getItem(position);
        holder.title.setText(basicData.getTitle());
        holder.start_date.setText(basicData.getStart_date());
        holder.end_date.setText(basicData.getEnd_date());
        holder.description.setText(basicData.getDescription());
        return row;
    }
}

