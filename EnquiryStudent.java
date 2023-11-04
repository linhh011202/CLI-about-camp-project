package student;

import java.util.*;

public class EnquiryStudent implements IEditEnquiry, IDeleteEnquiry, ISendEnquiry, IViewOwnEnquiry {
    Scanner sc = new Scanner(System.in);
    ArrayList<Enquiries> enquiries = new ArrayList<Enquiries>();

    public void sendEnquiry() {
        System.out.println("Type your enquiry: ");
        String text = sc.nextLine();
        Enquiries enquiry = new Enquiry(text, studentID);
        enquiry.add(text);
        System.out.println("Enquiry sent successfully. ");
    }

    public void editEnquiry() {
        System.out.println("Enter a keyword or phrase unique to the enquiry you want to edit: ");
        String searchKeyword = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < enquiry.size(); i++) {
            String currentEnquiry = enquiry.get(i);
            if (currentEnquiry.contains(searchKeyword)) {
                // Replace the current enquiry with the edited version
                System.out.println("Enter your updated enquiry: ");
                String text = sc.nextLine();
                enquiry.set(i, text);
                found = true;
                break; // Stop searching after the first match
            }
        }

        if (found) {
            System.out.println("Enquiry edited successfully.");
        } else {
            System.out.println("Enquiry not found.");
        }
    }

    public void deleteEnquiry() {
        System.out.println("Enter a keyword or phrase unique to the enquiry you want to delete: ");
        String searchKeyword = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < enquiry.size(); i++) {
            String currentEnquiry = enquiry.get(i);
            if (currentEnquiry.contains(searchKeyword)) {
                enquiry.remove(i);
                found = true;
                break; // Stop searching after the first match
            }
        }

        if (found) {
            System.out.println("Enquiry deleted successfully.");
        } else {
            System.out.println("Enquiry not found.");
        }
    }

    public void viewOwnEnquiry() {
        System.out.println("Your Enquiries:");
        for (int i = 0; i < enquiry.size(); i++) {
            if (enquiry.getStudentID() == studentID) {
                System.out.println(enquiry.getText());
            }
        }
    }
}
