package merge;

public class Enquiries {
    private static int lastEnquiryID = 0; // Static variable to track the last assigned ID
    private int enquiryID;
    private int studentID; // Unique identifier for the student who sent the enquiry
    private String text; // The text of the enquiry
    private String replyText;
    private String campName;

    public Enquiries(int studentID, String text, String replyText, String campName) {
        this.enquiryID = ++lastEnquiryID;
        this.studentID = studentID;
        this.text = text;
        this.replyText = replyText;
        this.campName = campName;
    }

    // Getters and setters for the properties
    public int getEnquiryID() {
        return enquiryID;
    }

    public void setEnquiryID(int enquiryID) {
        this.enquiryID = enquiryID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }
}
