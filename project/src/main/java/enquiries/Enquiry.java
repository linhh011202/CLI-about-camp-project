package enquiries;

import camp.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Enquiry implements Serializable{
    private int enquiryID;
    private String camp;
    private String text;
    private String user;
    private ArrayList<Enquiry> replies;

    public Enquiry(int enquiryID, String camp, String text, String user) {
        this.enquiryID = enquiryID;
        this.text = text;
        this.camp = camp;
        this.user = user;
        this.replies = new ArrayList<>();
    }

    public int getEnquiryID() {
        return enquiryID;
    }

    public String getCamp() {
        return camp;
    }

    public String getText() {
        return text;
    }

    public String getUser() {
        return user;
    }

    public ArrayList<Enquiry> getReplies() {
        return replies;
    }

    public void addReply(Enquiry reply) {
        replies.add(reply);
    }

    public void setCamp(String newCamp) {
        camp = newCamp;
    }

    public void setText(String newText) {
        text = newText;
    }
}
