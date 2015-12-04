package edu.brandeis.resufair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by wang on 2015/12/3.
 */
public class expInfo {
    private String title;
    private String description;
    private String start_date;
    private String end_date;
    private int id;
    private String email;
    private JSONArray experience;

    public expInfo(String id, String email, String title, String description, String start_date, String end_date) {
        this.id = Integer.parseInt(id);
        this.email = email;
        this.title = title;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public expInfo(JSONObject jsonObject) {
        try {
            this.experience = jsonObject.getJSONArray("experience");
        } catch (JSONException e) {

        }

    }

    ArrayList<expInfo> getInfo() {
        ArrayList<expInfo> result = new ArrayList<>();
        for (int i = 0; i < experience.length(); i++) {
            try {
                JSONObject edu = experience.getJSONObject(i);
                result.add(new expInfo(edu.getString("id"), edu.getString("appl_email"),
                        edu.getString("title"), edu.getString("description"),edu.getString("start_date"),
                        edu.getString("end_date")));
            } catch (JSONException e) {

            }

        }
        return result;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
