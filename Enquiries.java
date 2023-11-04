package student;

public class Enquiries {
    private int studentID; // Unique identifier for the student who sent the enquiry
    private String text; // The text of the enquiry

    public Enquiries(String text, int studentID) {
        this.studentID = studentID;
        this.text = text;
    }

    // Getters and setters for the properties
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
}
