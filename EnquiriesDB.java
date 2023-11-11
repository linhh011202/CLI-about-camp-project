package staff;

import java.util.Scanner;
import java.util.ArrayList;

public class EnquiriesDB implements IEditEnquiry, IDeleteEnquiry, ISendEnquiry, IViewOwnEnquiry {
    //Scanner sc = new Scanner(System.in);
    private ArrayList<Enquiries> enquiries = new ArrayList<Enquiries>();

    public void sendEnquiry(User user) {
        //add parser to get input
        //add error checking as students can only submit enquiries to any camp he/she can see
        System.out.println("Enter camp name: ");
        String campName = sc.nextLine();
        System.out.println("Type your enquiry: ");
        String text = sc.nextLine();
        Enquiries enquiry = new Enquiries(user.getName(), text, null, campName); // Assign null to replyText initially
        enquiries.add(enquiry);
        System.out.println("Enquiry sent successfully. ");
    }

    public void editEnquiry(int enquiryNumber, String newText, int newCamp, String user) {
        for (Enquiries enquiry : enquiries) {
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
        for (Enquiries enquiry : enquiries) {
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

    public void viewOwnEnquiry(User user) {
        System.out.println("Your Enquiries:");
        for (Enquiries enquiry : enquiries) {
            if (enquiry.getStudentID() == user.getName()) {
                System.out.println("Enquiry ID: " + enquiry.getEnquiryID());
                System.out.println("Camp Name: " + enquiry.getCampName());
                System.out.println("Enquiry: " + enquiry.getText());
            }
        }
    }
}
