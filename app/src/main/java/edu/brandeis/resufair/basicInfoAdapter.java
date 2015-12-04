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
public class basicInfoAdapter extends ArrayAdapter<basicInfo>{
    int layoutResourceId;
    static class infoHolder{
        TextView firstname;
        TextView lastname;
        TextView summary;
    }

    public int getCount(){
        return super.getCount();
    }

    public basicInfo getItem(int index){
        return super.getItem(index);
    }

    public long getItemId(int index){
        return index;
    }
    public basicInfoAdapter(Context mContext, int layoutResourceId, List<basicInfo> data){
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
            holder.firstname = (TextView)row.findViewById(R.id.first_name);
            holder.lastname = (TextView)row.findViewById(R.id.last_name);
            holder.summary = (TextView)row.findViewById(R.id.summary);

            row.setTag(holder);
        }else{
            holder = (infoHolder)row.getTag();
        }
        basicInfo basicData = this.getItem(position);
        holder.firstname.setText(basicData.getFirstname());
        holder.lastname.setText(basicData.getLastname());
        holder.summary.setText(basicData.getSummary());

        return row;
    }
}
