package student;

import java.util.*;

public class SuggestionCampCommittee extends CampCommittee
        implements IEditSuggestion, IDeleteSuggestion, ISendSuggestion, IViewOwnSuggestion {
    Scanner sc = new Scanner(System.in);
    ArrayList<Suggestions> suggestions = new ArrayList<Suggestions>();

    public void sendSuggestion() {
        System.out.println("Type your suggestion: ");
        String text = sc.nextLine();
        Suggestions suggestion = new Suggestions(text, studentID);
        suggestion.add(text);
        super.increasePoint();
        System.out.println("Suggestion sent successfully. ");
    }

    public void editSuggestion() {
        System.out.println("Enter a keyword or phrase unique to the suggestion you want to edit: ");
        String searchKeyword = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < suggestion.size(); i++) {
            String currentSuggestion = suggestion.get(i);
            if (currentSuggestion.contains(searchKeyword)) {
                // Replace the current suggestion with the edited version
                System.out.println("Enter your updated suggestion: ");
                String text = sc.nextLine();
                suggestion.set(i, text);
                found = true;
                break; // Stop searching after the first match
            }
        }

        if (found) {
            System.out.println("Suggestion edited successfully.");
        } else {
            System.out.println("Suggestion not found.");
        }
    }

    public void deleteSuggestion() {
        System.out.println("Enter a keyword or phrase unique to the suggestion you want to delete: ");
        String searchKeyword = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < suggestion.size(); i++) {
            String currentSuggestion = suggestion.get(i);
            if (currentSuggestion.contains(searchKeyword)) {
                suggestion.remove(i);
                found = true;
                break; // Stop searching after the first match
            }
        }

        if (found) {
            System.out.println("Suggestion deleted successfully.");
        } else {
            System.out.println("Suggestion not found.");
        }
    }

    public void viewOwnSuggestion() {
        System.out.println("Your Suggestions:");
        for (int i = 0; i < suggestion.size(); i++) {
            if (suggestion.getStudentID() == studentID) {
                System.out.println(suggestion.getText());
            }
        }
    }
}
