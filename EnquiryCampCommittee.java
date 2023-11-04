package student;

import java.util.*;

public class EnquiryCampCommittee extends CampCommittee implements IReplyEnquiries, IViewAllEnquiries {
    Scanner sc = new Scanner(System.in);
    ArrayList<Enquiries> enquiriesReplies = new ArrayList<Enquiries>();

    public void viewAllEnquiries() {
        for (int i = 0; i < enquiries.size; i++) {
            System.out.println("Your Enquiries:");
            System.out.println(enquiries.getText());

            Enquiries enquiriesReplies = new Enquiry(text, studentID);
            enquiriesReplies.add("null");
        }
    }

    public void replyEnquiries() {
        viewAllEnquiries();
        System.out.println("Input the enquiry number you would like to reply to: ");
        int i = sc.nextInt();
        System.out.println("Input your reply here: ");
        enquiriesReplies.set(i + 1, sc.nextLine());
        super.increasePoint();
        System.out.println("Enquiry replied successfully. ");
    }
}
