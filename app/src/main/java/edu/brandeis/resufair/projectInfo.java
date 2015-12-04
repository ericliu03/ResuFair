package edu.brandeis.resufair;

/**
 * Created by wang on 2015/12/3.
 */
public class projectInfo {
    private String title;
    private String description;
    private String start_date;
    private String end_date;

    public projectInfo(String title, String description, String start_date, String end_date) {
        this.title = title;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
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
