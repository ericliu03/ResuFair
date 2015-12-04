package edu.brandeis.resufair;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wang on 2015/12/3.
 */
public class basicInfo {
    private String firstname;
    private String lastname;
    private String summary;
    private String email;
    private String passWord;
    private int id;

    public basicInfo(JSONObject jsonObject) {
        try {
            this.firstname = jsonObject.getString("first_name");
            this.lastname = jsonObject.getString("last_name");
            this.summary = jsonObject.getString("summary");
            this.id = Integer.parseInt(jsonObject.getString("id"));
            this.email = jsonObject.getString("email");
            this.passWord = jsonObject.getString("password");
        } catch (JSONException e) {

        }

    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSummary() {
        return summary;
    }
}
