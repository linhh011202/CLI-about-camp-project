package suggestions;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import user.*;

import java.io.Serializable;
import java.time.LocalDate;

public class Suggestion implements Serializable{
    private int suggestionID;
    private boolean approved;
    private LocalDate date;
    private LocalDate lastEditDate;
    private LocalDate approveBy;
    private String camp;
    private String text;
    private String user;

    public Suggestion(int suggestionID, String camp, String text, String user) {
        this.suggestionID = suggestionID;
        this.approved = false;
        this.date = LocalDate.now();
        this.lastEditDate = LocalDate.now();
        this.approveBy = this.date.plusDays(5);
        this.camp = camp;
        this.text = text;
        this.user = user;
    }

    public int getSuggestionID() {
        return suggestionID;
    }

    public boolean getApproved() {
        return approved;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getLastEditDate() {
        return lastEditDate;
    }

    public LocalDate getApproveBy() {
        return approveBy;
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

    public void setApproved(boolean newApproved) {
        approved = newApproved;
    }

    public void setCamp(String newCamp) {
        camp = newCamp;
    }

    public void setText(String newText) {
        text = newText;
    }

    public void setLastEditDate(LocalDate newLastEditDate) {
        lastEditDate = newLastEditDate;
    }
}
