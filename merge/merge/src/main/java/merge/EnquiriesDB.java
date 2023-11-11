//package staff;
package merge;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class EnquiriesDB {//implements IEditEnquiry, IDeleteEnquiry, ISendEnquiry, IViewOwnEnquiry {
    //Scanner sc = new Scanner(System.in);
    private ArrayList<Enquiry> enquiriesDB = new ArrayList<Enquiry>();
    private static int enquiryIdCounter = 1;
    private ICheckSchoolMatch checkSchoolMatch;
    private ICheckCampVisibility CampVisibilityChecker;
    public EnquiriesDB(ICheckSchoolMatch checkSchoolMatch, ICheckCampVisibility campvisibilityChecker) {
        this.checkSchoolMatch=checkSchoolMatch;
        this.campvisibilityChecker=campvisibilityChecker;
    }
    public void addReply(int enquiryNumber, String replyText, List<String> campList) {
        for (Enquiry enquiry : enquiriesDB) {
            if (enquiry.getEnquiryID() == enquiryNumber) {
                if (campList.contains(enquiry.getCamp())) {
                    Enquiry reply = new Enquiry(enquiryIdCounter++, enquiry.getCamp(), replyText, enquiry.getUser());
                    enquiry.addReply(reply);
                    return;
                } else {
                    System.out.println("The specified comment is not for a camp managed by you.");
                    return;
                }
            }
        }
        System.out.println("The specified comment does not exist.");
    }

    public void sendEnquiry(String camp, String text, User user) {
        //add parser to get input
        //add error checking as students can only submit enquiries to any camp he/she can see
        boolean returnVal=campvisibilityChecker.isCampVisible(camp);
        if (!returnVal){
            return;
        }
        returnVal = checkSchoolMatch.checkSchoolMatch(user, camp);
        if (!returnVal){
            return;
        }
        Enquiry enquiry = new Enquiry(enquiryIdCounter++, camp, text, user.getName);
        enquiriesDB.add(enquiry);
        System.out.println("Enquiry sent successfully. ");
    }

    public void editEnquiry(int enquiryNumber, String newText, String newCamp, String user) {
        boolean returnVal=campvisibilityChecker.isCampVisible(camp);
        if (!returnVal){
            return;
        }
        returnVal = checkSchoolMatch.checkSchoolMatch(user, camp);
        if (!returnVal){
            return;
        }
        for (Enquiry enquiry : enquiriesDB) {
            if (enquiry.getEnquiryID() == enquiryNumber) {
                if (enquiry.getUser().equals(user) && enquiry.getReplies().isEmpty()) {
                    enquiry.setText(newText);
                    enquiry.setCamp(newCamp);
                    System.out.println("Enquiry edited successfully.");
                } else {
                    System.out.println("You can only edit your own enquires that are not processed.");
                }
                return; // Stop searching after the first match
            }
        }
        System.out.println("Enquiry not found.");
    }
    public void deleteEnquiry(int enquiryNumber, String user) {
        Enquiry toRemove = null;
        for (Enquiry enquiry : enquiriesDB) {
            if (enquiry.getEnquiryID() == enquiryNumber) {
                if (enquiry.getUser().equals(user) && enquiry.getReplies().isEmpty()) {
                    toRemove = enquiry;
                } else {
                    System.out.println("You can only delete your own enquires that are not processed.");
                }
            }
        }
        if (toRemove != null) {
            enquiriesDB.remove(toRemove);
            return;
        }
        System.out.println("Enquiry not found.");
    }
    public void displayEnquiries() {
        for (Enquiry enquiry : enquiriesDB) {
            displayEnquiry(enquiry, 0);
        }
    }
    private void displayEnquiry(Enquiry enquiry, int level) {
        System.out.println(" ".repeat(level * 2) + "Enquiry #" + enquiry.getEnquiryID() + " (by " + enquiry.getUser() + " about camp " + enquiry.getCamp() + "): " + enquiry.getText());
        for (Enquiry reply : enquiry.getReplies()) {
            displayEnquiry(reply, level + 1);
        }
    }
    public void viewOwnEnquiry(String user) {
        System.out.println("Your Enquiries:");
        for (Enquiry enquiry : enquiriesDB) {
            if (enquiry.getUser().equals(user)) {
                displayEnquiry(enquiry, 0);
            }
        }
    }
    public void viewByCamp(List<String> campList) {
        for (String camp : campList) {
            System.out.println("Enquiries for camp " + camp + ":");
            for (Enquiry enquiry : enquiriesDB) {
                if (enquiry.getCamp().equals(camp)) {
                    displayEnquiry(enquiry, 0);
                }
            }
        }
    }
}
