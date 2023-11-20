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

/** 
 * A database that stores all the existing enquiries in the system.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/

public class EnquiriesDB {// implements IEditEnquiry, IDeleteEnquiry, ISendEnquiry, IViewOwnEnquiry {
    /**
     * This is the EnquiriesDB's list of all enquiries.
     */
    private ArrayList<Enquiry> enquiriesDB = new ArrayList<Enquiry>();
    
    /**
     * This stores the next ID to be assigned to the next enquiry.
     */
    private static int enquiryIdCounter = 1;

    /**
     * An interface used by EnquiriesDB to check if the camp's faculty is open to the student.
     */
    private ICheckSchoolMatch checkSchoolMatch;

    /**
     * An interface used by EnquiriesDB to check if the camp is even visible to the student.
     */
    private ICheckCampVisibility campVisibilityChecker;

    /**
     * Creates a new EnquiriesDB object to store enquiries. This should only be called once to create a single database.
     * It then tries to find a storage txt file to scan and initialise itself with any Enquiry entries that might have
     * been stored from previous runs.
     * @param checkSchoolMatch An interface used by EnquiriesDB to check if the camp's faculty is open to the student.
     * @param campVisibilityChecker An interface used by EnquiriesDB to check if the camp is even visible to the student.
     */
    public EnquiriesDB(ICheckSchoolMatch checkSchoolMatch, ICheckCampVisibility campVisibilityChecker) {
        this.checkSchoolMatch = checkSchoolMatch;
        this.campVisibilityChecker = campVisibilityChecker;
        try{
            readFromStorage();
        }catch(Exception exception)
        {
            ;
        }

        enquiryIdCounter=enquiriesDB.size()+1;
    }

    //Functions to read and write to file for storage and retrieval of information
    //Read and write to storage
    /**
     * Writes this EnquiriesDB's array of Enquiry entries into a txt file. This should be called at the end of the
     * application in order to save the database into a file.
     * @throws IOException Throws an exception if it is unable to find the file to read or write to.
     */
    public void writeToStorage() throws IOException {
        File directory = new File("project\\src\\DataBaseInformation\\EnquiryInfo");
    
        // Check if have directory, else create if needed
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        try (FileOutputStream fileOutputStream = new FileOutputStream("project\\src\\DataBaseInformation\\EnquiryInfo\\EnquiryInfo.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
    
            for (int i = 0; i < enquiriesDB.size(); ++i) {
                objectOutputStream.writeObject(enquiriesDB.get(i));
            }
    
            objectOutputStream.flush();
        }
    }

    /**
     * Searches for the designated storage txt file to read in Enquiry data from previous app runs, and adds those
     * Enquiry objects to this EnquiriesDB database. If there is no storage file, does not read in anything and no new
     * Enquiry entries are added to this EnquiriesDB Database.
     * @throws IOException Thrown if it is unable to find the file to read or write to.
     * @throws ClassNotFoundException Thrown if unable to find class that we are trying to reference.
     */
    public void readFromStorage() throws IOException, ClassNotFoundException {
        try (
            FileInputStream fileInputStream = new FileInputStream("project\\src\\DataBaseInformation\\EnquiryInfo\\EnquiryInfo.txt");
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
    /**
     * Adds a reply to an Enquiry in EnquiriesDB database. Replies cannot be added to other replies. This should be
     * used only for staff and camp committee members to reply to students' enquiries.
     *
     * <p>
     * Example: enquiriesDB.addReply(enquiryNumber, replyText, staff0.getCampsCreated());
     * </p>
     * 
     * @param enquiryNumber Number of the enquiry to be replied.
     * @param replyText The reply text to the enquiry.
     * @param campList The list of camp names that the staff or camp committee member manages.
     * @return Boolean to indicate if reply was successfully added. Could be used to add points for camp committee
     * members.
     */
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

    /**
     * Sends an Enquiry to EnquiriesDB database. This should be used only for students to send enquiries to camps. Only
     * allows enquiries to be sent for camps that are visible to the student.
     * @param camp Camp name that the student wishes to enquire about.
     * @param text The enquiry about the camp.
     * @param student Student object that wishes to send an enquiry.
     */
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

    /**
     * Edits an Enquiry in EnquiriesDB database. This should be used only for students to edit enquiries. Only allows
     * enquiries to be sent for camps that are visible to the student. Enquiries can only be edited by the student that
     * sent it and before the enquiry is processed (replied to).
     * @param enquiryNumber Number of the enquiry to be edited.
     * @param newText The new text that the enquiry should be changed to.
     * @param newCamp The new camp that the enquiry is about.
     * @param student Student object that wishes to edit an enquiry.
     */
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

    /**
     * Deletes an Enquiry in EnquiriesDB database. This should be used only for students to delete enquiries. Enquiries
     * can only be deleted by the student that sent it and before the enquiry is processed (replied to).
     * @param enquiryNumber Number of the enquiry to be deleted.
     * @param user The name of student that wishes to delete an enquiry.
     */
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

    /**
     * Internal method to print the details of and replies to an enquiry.
     * @param enquiry Enquiry object details to be printed.
     * @param level Indicates if the enquiry object is a reply or not.
     */
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

    /**
     * Allows students to view their own enquiries and all replies to it in EnquiriesDB database. This should be used
     * only by students.
     * @param user The name of student that wishes to view his enquiries and all replies to him.
     */
    public void viewOwnEnquiry(String user) {
        System.out.println("Your Enquiries:");
        for (Enquiry enquiry : enquiriesDB) {
            if (enquiry.getUser().equals(user)) {
                displayEnquiry(enquiry, 0);
            }
        }
    }

    /**
     * Allows staff and camp committee members to view enquiries about camps managed by them and all replies. This
     * should be used only by staff and camp committee members.
     * @param campList The list of camp names that the staff or camp committee member manages.
     */
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
