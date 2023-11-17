package enquiries;

import camp.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.io.Serializable;
import java.util.ArrayList;

/** 
 * Represents an Enquiry entry created in the enquiries database. An enquiry entry contains information related to an
 * enquiry that a student sends about a camp, such as ID of enquiry, name of student, name of camp, what the enquiry is
 * about and the list of replies to that enquiry.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class Enquiry implements Serializable{
    /**
     * The unique enquiry number of this enquiry.
     */
    private int enquiryID;
    
    /**
     * The name of the camp that this enquiry is about.
     */
    private String camp;

    /**
     * The enquiry text.
     */
    private String text;

    /**
     * The name of the student that sent this enquiry.
     */
    private String user;

    /**
     * The list of replies to this enquiry.
     */
    private ArrayList<Enquiry> replies;

    /**
     * Creates a new Enquiry with the given attributes. The list of replies is initially empty.
     * @param enquiryID The unique enquiry number of this enquiry. Assignment is handled by EnquiriesDB database.
     * @param camp The name of the camp that this enquiry is about.
     * @param text The enquiry text.
     * @param user The name of the student that sent this enquiry.
     */
    public Enquiry(int enquiryID, String camp, String text, String user) {
        this.enquiryID = enquiryID;
        this.text = text;
        this.camp = camp;
        this.user = user;
        this.replies = new ArrayList<>();
    }

    /**
     * Gets the unique enquiry number of this enquiry.
     * @return The unique enquiry number of this enquiry.
     */
    public int getEnquiryID() {
        return enquiryID;
    }

    /**
     * Gets the name of the camp that this enquiry is about.
     * @return The name of the camp that this enquiry is about.
     */
    public String getCamp() {
        return camp;
    }

    /**
     * Gets the enquiry text.
     * @return The enquiry text.
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the name of the student that sent this enquiry.
     * @return The name of the student that sent this enquiry.
     */
    public String getUser() {
        return user;
    }

    /**
     * Gets the list of replies to this enquiry.
     * @return The list of replies to this enquiry.
     */
    public ArrayList<Enquiry> getReplies() {
        return replies;
    }

    /**
     * Adds a reply to this enquiry.
     * @param reply Reply to this enquiry.
     */
    public void addReply(Enquiry reply) {
        replies.add(reply);
    }

    /**
     * Changes the camp that this enquiry is about.
     * @param newCamp The name of the new camp that this enquiry is about.
     */
    public void setCamp(String newCamp) {
        camp = newCamp;
    }

    /**
     * Changes the enquiry text.
     * @param newText The new enquiry text.
     */
    public void setText(String newText) {
        text = newText;
    }
}
