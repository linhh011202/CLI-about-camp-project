package student;

public class CampCommittee extends Student implements IAddPoints {
    private int points = 0;

    public CampCommittee(String name, String password, String facultyInformation, int studentID) {
        super();
        super.isCommittee = true;
    }

    public void generateStudentReport() {
        // take from camp details
    }

    public boolean withdrawCamp(Camp camp) {
        System.out.println("Committee cannot withdraw from camp!");
        return false;
    }

    public void addPoints() {
        points++;
    }

    public int getPoints() {
        return points;
    }
}