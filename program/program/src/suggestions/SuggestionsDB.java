package merge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SuggestionsDB {
    private static ArrayList<Suggestion> suggestionsDB = new ArrayList<Suggestion>();
    private static int suggestionIdCounter = 1;
    
    public static void sendSuggestion(String camp, String text, String user) {
        //add parser to get input
        Suggestion suggestion = new Suggestion(suggestionIdCounter++, camp, text, user);
        suggestionsDB.add(suggestion);
        System.out.println("Suggestion sent successfully. ");
    }

    public static void editSuggestion(int suggestionNumber, String newText, String user) {
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
    
    public static void deleteSuggestion(int suggestionNumber, String user) {
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
    
    private static void displaySuggestion(Suggestion s) {
        System.out.println("Suggestion #" + s.getSuggestionID() + " for camp " + s.getCamp() + " by " + s.getUser() + ":");
        System.out.println("  Date suggested: " + s.getDate());
        System.out.println("  Date of last edit: " + s.getLastEditDate());
        System.out.println("  Date to be approved: " + s.getApproveBy());
        System.out.println("  Approved: " + s.getApproved());
        System.out.println("  Suggestion: " + s.getText());
    }
    public static void viewOwnSuggestion(String user) {
        System.out.println("Your Suggestions:");
        for (Suggestion suggestion : suggestionsDB) {
            if (suggestion.getUser().equals(user)) {
                displaySuggestion(suggestion);
                System.out.println();
            }
        }
    }
    public static void viewByCamp(List<String> campList) {
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
    public static String approveSuggestion(int suggestionNumber, List<String> campList) {
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
