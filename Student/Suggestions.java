public class Suggestions {
    private static int lastSuggestionID = 0;
    private int suggestionID;
    private int studentID; // Unique identifier for the student who sent the suggestion
    private String text; // The text of the suggestion
    private String replyText; // The reply to the suggestion
    private String campName;

    public Suggestions(int studentID, String text, String replyText, String campName) {
        this.suggestionID = ++lastSuggestionID;
        this.studentID = studentID;
        this.text = text;
        this.replyText = replyText;
        this.campName = campName;
    }

    // Getters and setters for the properties
    public int getSuggestionID() {
        return suggestionID;
    }

    public void setSuggestionID(int suggestionID) {
        this.suggestionID = suggestionID;
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