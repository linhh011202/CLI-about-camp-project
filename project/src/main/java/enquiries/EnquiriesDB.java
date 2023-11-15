package enquiries;

import camp.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EnquiriesDB {// implements IEditEnquiry, IDeleteEnquiry, ISendEnquiry, IViewOwnEnquiry {
    private ArrayList<Enquiry> enquiriesDB = new ArrayList<Enquiry>();
    private static int enquiryIdCounter = 1;
    private ICheckSchoolMatch checkSchoolMatch;
    private ICheckCampVisibility campVisibilityChecker;

    public EnquiriesDB(ICheckSchoolMatch checkSchoolMatch, ICheckCampVisibility campVisibilityChecker) {
        this.checkSchoolMatch = checkSchoolMatch;
        this.campVisibilityChecker = campVisibilityChecker;
        try{
            readFromStorage();
        }catch(Exception exception)
        {
            System.out.printf("No existing Enquiries information to retrieve from storage!\n");
        }

        enquiryIdCounter=enquiriesDB.size()+1;
    }

    //Functions to read and write to file for storage and retrieval of information
    //Read and write to storage
    public void writeToStorage() throws IOException {
        File directory = new File("project\\src\\EnquiryInfo");
    
        // Create the necessary directories if they don't exist
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        try (FileOutputStream fileOutputStream = new FileOutputStream("project\\src\\EnquiryInfo\\EnquiryInfo.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
    
            for (int i = 0; i < enquiriesDB.size(); ++i) {
                objectOutputStream.writeObject(enquiriesDB.get(i));
            }
    
            objectOutputStream.flush();
        }
    }

    public void readFromStorage() throws IOException, ClassNotFoundException {
        try (
            FileInputStream fileInputStream = new FileInputStream("project\\src\\EnquiryInfo\\EnquiryInfo.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) 
        {
            while (fileInputStream.available() > 0) {
                Enquiry enquiry = (Enquiry) objectInputStream.readObject();
                enquiriesDB.add(enquiry);
            }
        }
    }




    //Functions for users to interact with DB.
    public boolean addReply(int enquiryNumber, String replyText, List<String> campList) {
        for (Enquiry enquiry : enquiriesDB) {
            if (enquiry.getEnquiryID() == enquiryNumber) {
                if (campList.contains(enquiry.getCamp())) {
                    Enquiry reply = new Enquiry(enquiryIdCounter++, enquiry.getCamp(), replyText, enquiry.getUser());
                    enquiry.addReply(reply);
                    System.out.println("Reply added.");
                    return true;
                } else {
                    System.out.println("The specified enquiry is not about a camp managed by you.");
                    return false;
                }
            }
        }
        System.out.println("The specified enquiry does not exist.");
        return false;
    }

    public void sendEnquiry(String camp, String text, Student student) {
        // add parser to get input
        // add error checking as students can only submit enquiries to any camp he/she
        // can see
        boolean returnVal = campVisibilityChecker.isCampVisible(camp);
        if (!returnVal) {
            return;
        }
        returnVal = checkSchoolMatch.checkSchoolMatch(student, camp);
        if (!returnVal) {
            return;
        }
        Enquiry enquiry = new Enquiry(enquiryIdCounter++, camp, text, student.getName());
        enquiriesDB.add(enquiry);
        System.out.println("Enquiry sent successfully. ");
    }

    public void editEnquiry(int enquiryNumber, String newText, String newCamp, Student student) {
        boolean returnVal = campVisibilityChecker.isCampVisible(newCamp);
        if (!returnVal) {
            return;
        }
        returnVal = checkSchoolMatch.checkSchoolMatch(student, newCamp);
        if (!returnVal) {
            return;
        }
        for (Enquiry enquiry : enquiriesDB) {
            if (enquiry.getEnquiryID() == enquiryNumber) {
                if (enquiry.getUser().equals(student.getName()) && enquiry.getReplies().isEmpty()) {
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
                    return;
                }
            }
        }
        if (toRemove != null) {
            enquiriesDB.remove(toRemove);
            System.out.println("Enquiry deleted successfully.");
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
        if (level == 0) {
            System.out.println("Reply: ".repeat(level) + "Enquiry #" + enquiry.getEnquiryID() + " (by "
                    + enquiry.getUser() + " about camp " + enquiry.getCamp() + "): " + enquiry.getText());
        }
        if (level == 1) {
            System.out.println("  Reply: ".repeat(level) + enquiry.getText());
        }

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
