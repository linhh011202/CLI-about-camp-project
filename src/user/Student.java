package user;

public class Student extends User{
    public String type = "Student"; // Student have a type of Student

    public Student(String name, String email, String faculty){
        super(name, email, faculty); // super refer to the PARENT
    }

    // 1. Edit password
    public void editPassword() {
        // Implementation to edit password
    }

    // 2. Log out
    public void logOut() {
        // Implementation to log out
    }

    // 3. Register for a camp
    public void registerForCamp() {
        // Implementation to register for a camp
    }

    // 4. Deregister from a registered camp
    public void deregisterFromCamp() {
        // Implementation to deregister from a camp
    }

    // 5. Register as a Camp Committee
    public void registerAsCampCommittee() {
        // Implementation to register as a camp committee
    }

    // 6. View registered camps
    public void viewRegisteredCamps() {
        // Implementation to view registered camps
    }
    

}
