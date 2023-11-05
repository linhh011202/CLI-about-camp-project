package student;

import java.util.*;

public class SuggestionCampCommittee extends CampCommittee
        implements IEditSuggestion, IDeleteSuggestion, ISendSuggestion, IViewOwnSuggestion {
    Scanner sc = new Scanner(System.in);
    ArrayList<Suggestions> suggestions = new ArrayList<Suggestions>();

    public void sendSuggestion() {
        System.out.println("Enter camp name: ");
        String campName = sc.nextLine();
        System.out.println("Type your suggestion: ");
        String text = sc.nextLine();
        Suggestions suggestion = new Suggestions(studentID, text, null, campName);
        suggestions.add(suggestion);
        super.increasePoint(); //may need to change 
        System.out.println("Suggestion sent successfully. ");
    }

    public void editSuggestion() {
        System.out.println("Enter the suggestionID you want to edit: ");
        int suggestionID = sc.nextInt();
        sc.nextLine(); // Consume the newline character left in the input buffer

        boolean found = false;
        for (Suggestions suggestion : suggestions) {
            if (suggestion.getSuggestionID() == suggestionID) {
                System.out.println("Enter your updated suggestion: ");
                String updatedText = sc.nextLine();
                suggestion.setText(updatedText);
                found = true;
                System.out.println("Suggestion edited successfully.");
                break; // Stop searching after the first match
            }
        }
    }

    public void deleteSuggestion() {
        System.out.println("Enter the suggestionID you want to delete: ");
        int suggestionID = sc.nextInt();
        sc.nextLine(); 
        Suggestions suggestionToRemove = null;
        for (Suggestions suggestion : suggestions) {
            if (suggestion.getSuggestionID() == suggestionID) {
                suggestionToRemove = suggestion;
                break; // Stop searching after the first match
            }
        }

        if (suggestionToRemove != null) {
            suggestions.remove(suggestionToRemove);
            System.out.println("Suggestion deleted successfully.");
        } else {
            System.out.println("Suggestion not found.");
        }
    }

    public void viewOwnSuggestion() {
        System.out.println("Your Suggestions:");
        for (Suggestions suggestion : suggestions) {
            if (suggestion.getStudentID() == studentID) {
                System.out.println("Suggestion ID: " + suggestion.getSuggestionID());
                System.out.println("Camp Name: " + suggestion.getCampName());
                System.println("Suggestion: " + suggestion.getText());
            }
        }
    }    
}
