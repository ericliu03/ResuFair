package edu.brandeis.resufair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by wang on 2015/12/3.
 */
public class eduInfo {
    private String school;
    private String degree;
    private String major;
    private float gpa;
    private String start_date;
    private String end_date;
    private String description;
    private int id;
    private String email;
    private JSONArray education;
    public eduInfo(String id, String email, String school, String degree, String major, float gpa, String start_date, String end_date, String description) {
        this.school = school;
        this.degree = degree;
        this.major = major;
        this.gpa = gpa;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
        this.id = Integer.parseInt(id);
        this.email = email;
    }

    public eduInfo(JSONObject jsonObject) {
        try {
            this.education = jsonObject.getJSONArray("education");
        } catch (JSONException e) {

        }

    }

    ArrayList<eduInfo> getInfo() {
        ArrayList<eduInfo> result = new ArrayList<>();
        for (int i = 0; i < education.length(); i++) {
            try {
                JSONObject edu = education.getJSONObject(i);
                result.add(new eduInfo(edu.getString("id"), edu.getString("appl_email"),
                        edu.getString("school"), edu.getString("degree"), edu.getString("major"),
                        Float.parseFloat(edu.getString("gpa")), edu.getString("start_date"),
                        edu.getString("end_date"), edu.getString("description")));
            } catch (JSONException e) {

            }

        }
        return result;
    }
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
