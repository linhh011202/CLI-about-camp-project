package student;

import java.util.ArrayList;

public class Student extends User {
    protected boolean isCommittee = false;
    protected int studentID;

    public Student(String name, String password, String facultyInformation, int studentID) {
        super(name, password, facultyInformation);
        this.studentID = studentID;
        this.allCamps = new ArrayList<>();
        this.registeredCamps = new ArrayList<>();
    }

    public String getName() {
        return super.name;
    }

    public String getFacultyInformation() {
        return super.facultyInformation;
    }

    public int getStudentID() {
        return this.studentID;
    }

    public void viewAllCamps(Student student) {
        // havent implement
    }

    public void viewRegisteredCamps(Student student) {
        //havent implement 
    }

    public void setCommittee(boolean isCommittee) {
        this.isCommittee = true;
    }

    public boolean registerCamp(Camp camp) {
        if (camp.registerStudent(this)) { // conditions must be met eg date, headcount, and need to choose which role to
                                          // sign up for
            registeredCamps.add(camp);
            setCommittee(isCommittee);
            return true;
        }
        return false;
    }

    public boolean withdrawCamp(Camp camp) {
        if (camp.unregisterStudent(this)) {
            registeredCamps.remove(camp);
            return true;
        }
        return false;
    }

    public String viewRole(Camp camp) {
        if (isCommittee) {
            System.out.println("Role: Committee");
        } else
            System.out.println("Role: Participant");
    }
}
