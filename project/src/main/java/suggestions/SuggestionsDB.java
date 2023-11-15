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

public class SuggestionsDB {
    private ArrayList<Suggestion> suggestionsDB = new ArrayList<Suggestion>();
    private static int suggestionIdCounter = 1;

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
    public void writeToStorage() throws IOException {
        File directory = new File("project\\src\\SuggestionInfo");
    
        // Create the necessary directories if they don't exist
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
    public void sendSuggestion(String camp, String text, String user) {
        // add parser to get input
        Suggestion suggestion = new Suggestion(suggestionIdCounter++, camp, text, user);
        suggestionsDB.add(suggestion);
        System.out.println("Suggestion sent successfully. ");
    }

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

    private void displaySuggestion(Suggestion s) {
        System.out.println(
                "Suggestion #" + s.getSuggestionID() + " for camp " + s.getCamp() + " by " + s.getUser() + ":");
        System.out.println("  Date suggested: " + s.getDate());
        System.out.println("  Date of last edit: " + s.getLastEditDate());
        System.out.println("  Date to be approved: " + s.getApproveBy());
        System.out.println("  Approved: " + s.getApproved());
        System.out.println("  Suggestion: " + s.getText());
    }

    public void viewOwnSuggestion(String user) {
        System.out.println("Your Suggestions:");
        for (Suggestion suggestion : suggestionsDB) {
            if (suggestion.getUser().equals(user)) {
                displaySuggestion(suggestion);
                System.out.println();
            }
        }
    }

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
