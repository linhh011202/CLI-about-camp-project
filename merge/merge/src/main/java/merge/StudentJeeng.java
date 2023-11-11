/* 
package merge;

import java.util.ArrayList;

public class Student extends User {
    protected boolean isCommittee = false;
    protected int studentID;
    protected IViewAllCamps studentViewAllCamps;
    protected IViewRegisteredCamps studentRegisteredCampsViewer; 


    public Student(String name, String password, String facultyInformation, int studentID, IViewAllCamps studentViewAllCamps, ISortCamps iSortCamps, IFilterCamps iFilterCamps, String filterString, IViewRegisteredCamps studentRegisteredCampsViewer) {
        super(name, password, facultyInformation, iSortCamps, iFilterCamps, filterString);
        this.studentID = studentID;
        this.studentViewAllCamps = studentViewAllCamps;
        this.studentRegisteredCampsViewer = studentRegisteredCampsViewer;

    }

    public String getName() {
        return super.getName();
    }

    public String getFacultyInformation() {
        return super.getFacultyInformation();
    }

    public String getStudentID() {
        return this.getStudentID;
    }

    public void viewAllCamps() {
        this.studentViewAllCamps.viewAllCamps(this, iSortCamps, iFilterCamps, filterString);
    }

    public void viewRegisteredCamps() {
        this.studentRegisteredCampsViewer.viewRegisteredCamps(this, iSortCamps, iFilterCamps, filterString);
    }

    public void setCommittee() {
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

    public String viewRole(boolean isCommittee) {
        if (isCommittee) {
            System.out.println("Role: Committee");
        } else
            System.out.println("Role: Participant");
    }
}
*/