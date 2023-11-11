package student;

import java.util.*;

public class EnquiryCampCommittee extends CampCommittee implements IReplyEnquiries, IViewAllEnquiries {
    Scanner sc = new Scanner(System.in);
    ArrayList<Enquiries> enquiries; // This is an instance variable

    public EnquiryCampCommittee(ArrayList<Enquiries> enquiries) {
        this.enquiries = enquiries; // Initialize the enquiries ArrayList when creating an instance
    }

    public void viewAllEnquiries() {
        System.out.println("All Enquiries:");
        for (Enquiries enquiry : enquiries) {
            System.out.println("Enquiry ID: " + enquiry.getEnquiryID());
            System.out.println("Student ID: " + enquiry.getStudentID());
            System.out.println("Enquiry: " + enquiry.getText());
            System.out.println("Camp Name: " + enquiry.getCampName());
            System.out.println("Reply: " + enquiry.getReplyText());
            System.out.println();
        }
    }

    public void replyEnquiries() {
        viewAllEnquiries();
        System.out.println("Input the enquiry ID you would like to reply to: ");
        int enquiryNumber = sc.nextInt();
        sc.nextLine();

        for (Enquiries enquiry : enquiries) {
            if (enquiry.getEnquiryID() == enquiryNumber) {
                System.out.println("Input your reply here: ");
                String reply = sc.nextLine();
                enquiry.setReplyText(reply);
                super.addPoints();
                System.out.println("Enquiry replied successfully. ");
                break;
            }
        }

        System.out.println("Enquiry not found.");
    }
}
