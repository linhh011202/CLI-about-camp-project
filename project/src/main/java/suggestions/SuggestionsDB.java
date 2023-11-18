package suggestions;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import user.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** 
 * A database that stores all the existing suggestions in the system.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class SuggestionsDB {

    /**
     * This is the SuggestionsDB's list of all suggestions.
     */
    private ArrayList<Suggestion> suggestionsDB = new ArrayList<Suggestion>();

    /**
     * This stores the next ID to be assigned to the next suggestion.
     */
    private static int suggestionIdCounter = 1;

    /**
     * Creates a new SuggestionsDB object to store suggestions. This should only be called once to create a single database.
     * It then tries to find a storage txt file to scan and initialise itself with any Suggestion entries that might have
     * been stored from previous runs.
     */
    public SuggestionsDB()
    {
        try{
            readFromStorage();
        }catch(Exception exception)
        {
            System.out.printf("No existing Suggestions information to retrieve from storage!\n");
        }

        suggestionIdCounter=suggestionsDB.size()+1;
    }


    //Functions to read and write to file for storage and retrieval of information
    //Read and write to storage
    /**
     * Writes this SuggestionsDB's array of Suggestion entries into a txt file. This should be called at the end of the
     * application in order to save the database into a file.
     * @throws IOException Throws an exception if it is unable to find the file to read or write to.
     */
    public void writeToStorage() throws IOException {
        File directory = new File("project\\src\\SuggestionInfo");
    
        //Check if have directory, else create if needed
        if (!directory.exists()) {
            directory.mkdirs();
        }
    
        try (FileOutputStream fileOutputStream = new FileOutputStream("project\\src\\SuggestionInfo\\SuggestionInfo.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
    
            for (int i = 0; i < suggestionsDB.size(); ++i) {
                objectOutputStream.writeObject(suggestionsDB.get(i));
            }
    
            objectOutputStream.flush();
        }
    }
    
    /**
     * Searches for the designated storage txt file to read in Suggestion data from previous app runs, and adds those
     * Suggestion objects to this SuggestionsDB database. If there is no storage file, does not read in anything and no new
     * Suggestion entries are added to this SuggestionsDB database.
     * @throws IOException Thrown if it is unable to find the file to read or write to.
     * @throws ClassNotFoundException Thrown if unable to find class that we are trying to reference.
     */
    public void readFromStorage() throws IOException, ClassNotFoundException {
        try (
            FileInputStream fileInputStream = new FileInputStream("project\\src\\SuggestionInfo\\SuggestionInfo.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) 
        {
            while (fileInputStream.available() > 0) {
                Suggestion suggestion = (Suggestion) objectInputStream.readObject();
                suggestionsDB.add(suggestion);
            }
        }
    }




    //Functions for users to interact with storage
    /**
     * Sends a Suggestion to SuggestionsDB database. This should be used only for camp committee members to send suggestions
     * about the camp he manages.
     *
     * <p>
     * Example: suggestionsDB.sendSuggestion(((CampCommittee)currentUser).getCampName(), suggestionText, currentUser.getName());
     * </p>
     * 
     * @param camp The name of the camp that the camp committee member manages.
     * @param text The suggestion text about the camp.
     * @param user The name of the camp committee member that wishes to send a suggestion.
     */
    public void sendSuggestion(String camp, String text, String user) {
        // add parser to get input
        Suggestion suggestion = new Suggestion(suggestionIdCounter++, camp, text, user);
        suggestionsDB.add(suggestion);
        System.out.println("Suggestion sent successfully. ");
    }

    /**
     * Edits a Suggestion in SuggestionsDB database. This should be used only for camp committee members to edit suggestions.
     * Suggestions can only be edited by the camp committee member that sent it and before the suggestion is processed (approved
     * or rejected).
     * @param suggestionNumber ID of the suggestion to be edited.
     * @param newText The new text that the suggestion should be changed to.
     * @param user The name of the camp committee member that wishes to edit a suggestion.
     */
    public void editSuggestion(int suggestionNumber, String newText, String user) {
        for (Suggestion suggestion : suggestionsDB) {
            if (suggestion.getSuggestionID() == suggestionNumber) {
                if (!suggestion.getUser().equals(user)) {
                    System.out.println("That suggestion was not made by you.");
                    return;
                }
                if (suggestion.getApproved()) {
                    System.out.println("Suggestion already processed.");
                    return;
                }
                if (suggestion.getApproveBy().isBefore(LocalDate.now())) {
                    System.out.println("Suggestion not approved.");
                    return;
                }
                suggestion.setText(newText);
                suggestion.setLastEditDate(LocalDate.now());
                System.out.println("Suggestion edited successfully.");
                return;
            }
        }
        System.out.println("Suggestion not found.");
    }

    /**
     * Deletes a Suggestion from SuggestionsDB database. This should be used only for camp committee members to delete
     * suggestions. Suggestions can only be deleted by the camp committee member that sent it and before the suggestion is
     * processed (approved or rejected).
     * @param suggestionNumber ID of the suggestion to be deleted.
     * @param user The name of the camp committee member that wishes to delete a suggestion.
     */
    public void deleteSuggestion(int suggestionNumber, String user) {
        Suggestion toRemove = null;
        for (Suggestion suggestion : suggestionsDB) {
            if (suggestion.getSuggestionID() == suggestionNumber) {
                if (!suggestion.getUser().equals(user)) {
                    System.out.println("That suggestion was not made by you.");
                    return;
                }
                if (suggestion.getApproved()) {
                    System.out.println("Suggestion already processed.");
                    return;
                }
                if (suggestion.getApproveBy().isBefore(LocalDate.now())) {
                    System.out.println("Suggestion not approved.");
                    return;
                }
                toRemove = suggestion;
            }
        }
        if (toRemove != null) {
            suggestionsDB.remove(toRemove);
            System.out.println("Suggestion deleted successfully.");
            return;
        }
        System.out.println("Suggestion not found.");
    }

    /**
     * Internal method to print the details of Suggestion.
     * @param s Suggestion object details to be printed.
     */
    private void displaySuggestion(Suggestion s) {
        System.out.println(
                "Suggestion #" + s.getSuggestionID() + " for camp " + s.getCamp() + " by " + s.getUser() + ":");
        System.out.println("  Date suggested: " + s.getDate());
        System.out.println("  Date of last edit: " + s.getLastEditDate());
        System.out.println("  Date to be approved: " + s.getApproveBy());
        System.out.println("  Approved: " + s.getApproved());
        System.out.println("  Suggestion: " + s.getText());
    }

    /**
     * Allows camp committee members to view their own Suggestions in SuggestionsDB database. This should be used
     * only by camp committee members.
     * @param user The name of camp committee member that wishes to view his Suggestions and their status.
     */
    public void viewOwnSuggestion(String user) {
        System.out.println("Your Suggestions:");
        for (Suggestion suggestion : suggestionsDB) {
            if (suggestion.getUser().equals(user)) {
                displaySuggestion(suggestion);
                System.out.println();
            }
        }
    }

    /**
     * Allows staff to view Suggestions about camps managed by them. This should be used only by staff.
     *
     * <p>
     * Example: suggestionsDB.viewByCamp(staff1.getCampsCreated());
     * </p>
     * 
     * @param campList The list of the names of camps that the staff manages.
     */
    public void viewByCamp(List<String> campList) {
        for (String camp : campList) {
            System.out.println("Suggestions for camp " + camp + ":");
            for (Suggestion suggestion : suggestionsDB) {
                if (suggestion.getCamp().equals(camp)) {
                    displaySuggestion(suggestion);
                    System.out.println();
                }
            }
        }
    }

    /**
     * Approves a Suggestion in SuggestionsDB database. This should be used only by staff. Suggestions about a camp
     * can only be approved by the staff that created the camp and before the suggestion is expired (before the date
     * to be approved by).
     * @param suggestionNumber ID of the suggestion to be approved.
     * @param campList The list of the names of camps that the staff manages.
     */
    public String approveSuggestion(int suggestionNumber, List<String> campList) {
        for (Suggestion suggestion : suggestionsDB) {
            if (suggestion.getSuggestionID() == suggestionNumber) {
                if (campList.contains(suggestion.getCamp())) {
                    if (suggestion.getApproveBy().isBefore(LocalDate.now())) {
                        System.out.println("Suggestion not approved as it has expired.");
                        return null;
                    }
                    if (suggestion.getApproved()) {
                        System.out.println("Suggestion already approved.");
                        return null;
                    }
                    suggestion.setApproved(true);
                    System.out.println("Suggestion approved successfully.");
                    return suggestion.getUser();
                } else {
                    System.out.println("The specified suggestion is not for a camp managed by you.");
                    return null;
                }
            }
        }
        System.out.println("Suggestion not found.");
        return null;
    }
}
