package student;

import java.util.*;

public class EnquiryStudent implements IEditEnquiry, IDeleteEnquiry, ISendEnquiry, IViewOwnEnquiry {
    Scanner sc = new Scanner(System.in);
    ArrayList<Enquiries> enquiries = new ArrayList<Enquiries>();

    public void sendEnquiry() {
        System.out.println("Enter camp name: ");
        String campName = sc.nextLine();
        System.out.println("Type your enquiry: ");
        String text = sc.nextLine();
        Enquiries enquiry = new Enquiries(studentID, text, null, campName); // Assign null to replyText initially
        enquiries.add(enquiry);
        System.out.println("Enquiry sent successfully. ");
    }

    public void editEnquiry() {
        System.out.println("Enter the enquiry ID you want to edit: ");
        int enquiryNumber = sc.nextInt();
        sc.nextLine(); // Consume the newline character left in the input buffer

        boolean found = false;
        for (Enquiries enquiry : enquiries) {
            if (enquiry.getEnquiryID() == enquiryNumber) {
                System.out.println("Enter your updated enquiry: ");
                String updatedText = sc.nextLine();
                enquiry.setText(updatedText);
                found = true;
                System.out.println("Enquiry edited successfully.");
                break; // Stop searching after the first match
            }
        }

        if (!found) {
            System.out.println("Enquiry edited successfully.");
        }
    }

    public void deleteEnquiry() {
        System.out.println("Enter the enquiry ID you want to delete: ");
        int enquiryNumber = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        Iterator<Enquiries> iterator = enquiries.iterator();

        while (iterator.hasNext()) {
            Enquiries enquiry = iterator.next();
            if (enquiry.getEnquiryID() == enquiryNumber) {
                iterator.remove(); // Safely remove the enquiry using the iterator
                found = true;
                System.out.println("Enquiry deleted successfully.");
                break; // Stop searching after the first match
            }
        }

        if (!found) {
            System.out.println("Enquiry not found.");
        }
    }

    public void viewOwnEnquiry() {
        System.out.println("Your Enquiries:");
        for (Enquiries enquiry : enquiries) {
            if (enquiry.getStudentID() == studentID) {
                System.out.println("Enquiry ID: " + enquiry.getEnquiryID());
                System.out.println("Camp Name: " + enquiry.getCampName());
                System.out.println("Enquiry: " + enquiry.getText());
            }
        }
    }
}
