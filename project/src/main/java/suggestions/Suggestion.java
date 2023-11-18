package suggestions;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import user.*;

import java.io.Serializable;
import java.time.LocalDate;

/** 
 * Represents a Suggestion entry created in the SuggestionsDB database. A suggestion entry contains information related
 * to a suggestion that a camp committee member sends about a camp.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class Suggestion implements Serializable{
    /**
     * The unique suggestion number of this suggestion.
     */
    private int suggestionID;
    
    /**
     * Whether this suggestion has been approved.
     */
    private boolean approved;
    
    /**
     * The date this suggestion was made.
     */
    private LocalDate date;

    /**
     * The date this suggestion was last edited.
     */
    private LocalDate lastEditDate;
    
    /**
     * The date this suggestion has to be approved by, after which the suggestion expires and is considered as rejected.
     */
    private LocalDate approveBy;

    /**
     * The name of the camp that this suggestion is about.
     */
    private String camp;

    /**
     * The suggestion text.
     */
    private String text;

    /**
     * The name of the camp committee member that suggested this suggestion.
     */
    private String user;

    /**
     * Creates a new Suggestion with the given attributes. The suggestion is not approved initially. The last edit date
     * is initially set to the date the suggestion was created. The date the suggestion has to be approved by is set to
     * be 5 days from the date that the suggestion was made, by default.
     * @param suggestionID The unique suggestion number of this suggestion. Assignment is handled by SuggestionsDB database.
     * @param camp The name of the camp that this suggestion is about.
     * @param text The suggestion text.
     * @param user The name of the camp committee member that suggested this suggestion.
     */
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

    /**
     * Gets the unique suggestion number of this suggestion.
     * @return The unique suggestion number of this suggestion.
     */
    public int getSuggestionID() {
        return suggestionID;
    }

    /**
     * Gets whether this suggestion has been approved.
     * @return Whether this suggestion has been approved.
     */
    public boolean getApproved() {
        return approved;
    }

    /**
     * Gets the date this suggestion was made.
     * @return The date this suggestion was made.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets the date this suggestion was last edited.
     * @return The date this suggestion was last edited.
     */
    public LocalDate getLastEditDate() {
        return lastEditDate;
    }

    /**
     * Gets the date the suggestion has to be approved by.
     * @return The date the suggestion has to be approved by.
     */
    public LocalDate getApproveBy() {
        return approveBy;
    }

    /**
     * Gets the name of the camp that this suggestion is about.
     * @return The name of the camp that this suggestion is about.
     */
    public String getCamp() {
        return camp;
    }

    /**
     * Gets the suggestion text.
     * @return The suggestion text.
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the name of the camp committee member that suggested this suggestion.
     * @return The name of the camp committee member that suggested this suggestion.
     */
    public String getUser() {
        return user;
    }

    /**
     * Changes whether this suggestion has been approved.
     * @param newApproved Whether this suggestion has been approved.
     */
    public void setApproved(boolean newApproved) {
        approved = newApproved;
    }

    /**
     * Changes the name of the camp that this suggestion is about.
     * @param newCamp The name of the new camp that this suggestion is about.
     */
    public void setCamp(String newCamp) {
        camp = newCamp;
    }

    /**
     * Changes the suggestion text.
     * @param newText The new suggestion text.
     */
    public void setText(String newText) {
        text = newText;
    }

    /**
     * Changes the date this suggestion was last edited.
     * @param newLastEditDate The new date this suggestion was last edited.
     */
    public void setLastEditDate(LocalDate newLastEditDate) {
        lastEditDate = newLastEditDate;
    }
}
