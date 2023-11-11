//package staff;

import java.util.Scanner;
import java.util.ArrayList;

public class EnquiriesDB {//implements IEditEnquiry, IDeleteEnquiry, ISendEnquiry, IViewOwnEnquiry {
    //Scanner sc = new Scanner(System.in);
    private ArrayList<Enquiry> enquiriesDB = new ArrayList<Enquiry>();
    private static int enquiryIdCounter = 1;

    public void sendEnquiry(String camp, String text, String user) {
        //add parser to get input
        //add error checking as students can only submit enquiries to any camp he/she can see
        Enquiry enquiry = new Enquiry(enquiryIdCounter++, camp, text, user);
        enquiriesDB.add(enquiry);
        System.out.println("Enquiry sent successfully. ");
    }

    public void editEnquiry(int enquiryNumber, String newText, int newCamp, String user) {
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
            enquiries.remove(toRemove);
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
        System.out.println(" ".repeat(level * 2) + "Comment #" + enquiry.getEnquiryID() + " (by " + enquiry.getUser() + " about camp " + enquiry.getCamp() + "): " + enquiry.getText());
        for (Enquiry reply : enquiry.getReplies()) {
            displayComment(reply, level + 1);
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
}
