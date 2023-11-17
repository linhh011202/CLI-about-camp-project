package user;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;

/** 
 * Represents a Student in the system. A student can interact with the various camp, enquiries, registration and suggestions databases.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class Student extends User {

    /**
     * This Student's faculty.
     */
    private Faculty faculty;

    /**
     * This Student's committee status.
     */
    private boolean isCommittee;

    // Interfaces it uses

    /**
     * This Student's interface it utilises to register for camps as attendee.
     */
    private IRegisterCamp studentCampRegisterer;

    /**
     * This Student's interface it utilises to deregister for camps as attendee.
     */
    private IDeregisterCamp studentCampDeregisterer;

    /**
     * This Student's interface it utilises to register for camps as a camp committee member.
     */
    private IRegisterCommittee committeeCampRegisterer;

    /**
     * This Student's interface it utilises to view all his registered camps.
     */
    private IViewRegisteredCamps studentRegisteredCampsViewer;

    /**
     * This Student's interface it utilises to generate a report for all the camps he is a camp committee member of.
     */
    private IGenerateStudentReport campComStudentReportGenerator;


    /**
     * Creates a new Student object, with the given name, faculty, associated user database, and interfaces it requires from 
     * {@link CampDataBase} and {@link RegistrationDataBase}.
     * @param name This Student's name.
     * @param studentViewAllCamps Interface this Student uses to view all the camps that he can see.
     * @param faculty This Student's faculty.
     * @param iSortCamps Interface this Student uses to sort the camps in the database before viewing or generating camp reports.
     * @param studentCampRegisterer Interface this Student uses to register for camps as an attendee.
     * @param studentCampDeregisterer Interface this Student uses to deregister from camps.
     * @param commiteeCampRegisterer Interface this Student uses register for camps as a camp committee member.
     * @param studentRegisteredCampsViewer Interface this Student uses to view the details of all his registered camps, and his roles in them.
     * @param iFilterCamps Interface this Student uses to filter the camps.
     * @param campComStudentReportGenerator Interface this Student uses to generate a report for all the camps the student is a camp committee member of.
     * @param userDataBase This Student's associated user database.
     */
    public Student(String name, IViewAllCamps studentViewAllCamps, Faculty faculty, ISortCamps iSortCamps,
            IRegisterCamp studentCampRegisterer, IDeregisterCamp studentCampDeregisterer,
            IRegisterCommittee commiteeCampRegisterer, IViewRegisteredCamps studentRegisteredCampsViewer,
            IFilterCamps iFilterCamps, IGenerateStudentReport campComStudentReportGenerator,
            UserDataBase userDataBase) {
        super(name, iSortCamps, iFilterCamps, userDataBase, studentViewAllCamps);
        this.isCommittee = false;
        this.faculty = faculty;
        this.studentCampRegisterer = studentCampRegisterer;
        this.studentCampDeregisterer = studentCampDeregisterer;
        this.committeeCampRegisterer = commiteeCampRegisterer;
        this.studentRegisteredCampsViewer = studentRegisteredCampsViewer;
        this.campComStudentReportGenerator = campComStudentReportGenerator;
    }

    // Copy constructor
    /**
     * Copy constructor for the this Student.
     * @param student This Student to be copied.
     */
    public Student(Student student) {
        super(student.getName(), student.getSortCamps(), student.getFilterCamps(), student.getUserDataBase(),
                student.getIViewAllCamps());
        this.isCommittee = student.getIsCommittee();
        this.faculty = student.getFaculty();
        this.studentCampRegisterer = student.getStudentCampRegisterer();
        this.studentCampDeregisterer = student.getStudentCampDeregisterer();
        this.committeeCampRegisterer = student.getCommitteeCampRegisterer();
        this.studentRegisteredCampsViewer = student.getStudentRegisteredCampsViewer();
        this.campComStudentReportGenerator = student.getCampComStudentReportGenerator();
    }

    // Getters and Setters

    /**
     * Gets this Student's faculty.
     * @return This Student's faculty as an enum.
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * Sets this Student's faculty.
     * @param faculty This Student's new faculty.
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * Gets this Student's camp committee status.
     * @return This Student's camp committee status.
     */
    public boolean getIsCommittee() {
        return isCommittee;
    }

    /**
     * Changes this Student's camp committee status.
     * @param isCommittee This Student's new camp committee status.
     */
    public void setIsCommittee(boolean isCommittee) {
        this.isCommittee = isCommittee;
    }

    /**
     * Gets this Student's interface used to register for camps as a camp attendee.
     * @return This Student's interface used to register for camps as a camp attendee.
     */
    public IRegisterCamp getStudentCampRegisterer() {
        return studentCampRegisterer;
    }

    /**
     * Gets this Student's interface used to deregister for camps.
     * @return This Student's interface used to deregister for camps.
     */
    public IDeregisterCamp getStudentCampDeregisterer() {
        return studentCampDeregisterer;
    }

    /**
     * Gets this Student's interface used to register as a camp committee member for camps.
     * @return This Student's interface used to register as a camp committee member for camps.
     */
    public IRegisterCommittee getCommitteeCampRegisterer() {
        return committeeCampRegisterer;
    }

    /**
     * Gets this Student's interface used to view all the camps he has registered for.
     * @return This Student's interface used to view all the camps he has registered for.
     */
    public IViewRegisteredCamps getStudentRegisteredCampsViewer() {
        return studentRegisteredCampsViewer;
    }

    /**
     * Get this Student's interface used to generate a camp report for all the camps he is a committee member of.
     * @return This Student's interface used to generate a camp report for all the camps he is a committee member of.
     */
    public IGenerateStudentReport getCampComStudentReportGenerator() {
        return campComStudentReportGenerator;
    }

    // Testing Functions:
    /**
     * Registers this Student for a camp. Error message printed on failure.
     * @param campName The camp name the student wants to register for.
     */
    public void registerCampStudent(String campName) {
        studentCampRegisterer.registerCamp(this, campName);
    }

    /** 
     * Deregisters this Student from a camp. Error message printed on failure.
     * @param campName The camp name the student wants to deregister for.
     */
    public void deregisterCamp(String campName) {
        studentCampDeregisterer.deregisterCamp(this, campName);
    }

    /**
     * Registers this Student as a camp committee member for a camp. Upon success, it returns a upgraded campcommittee object. Upon failure,
     * it returns the same student object that initially called the function.
     * The proper use of this function is as follows: 
     * <p>
     * student=student.registerCampCommittee("campName");
     * </p>
     * @param campName The camp name the student wants to register as a camp committee member for.
     * @return On success, a student reference to a promoted camp committee object. On failure, the original student reference that was passed in as a parameter is returned.
     */
    public Student registerCampCommittee(String campName) {
        return committeeCampRegisterer.registerCamp(this, campName);
    }

    /**
     * Prints the details of all the camps the student has registered for, including his roles, in his preferred sorting, filtering order.
     */
    public void viewRegisteredCamps() {
        studentRegisteredCampsViewer.viewRegisteredCamps(this, getSortCamps(), getFilterCamps(), getFilterString());
    }

    /**
     * Requests for the user to input a filename, and generates a report including the camp details, camp participants and their corresponding roles
     * in the said file. If the user is not a Camp committee member of any camps, the file is not generated and an error message is printed to the console.
     */
    public void generateCampComReport() {
        campComStudentReportGenerator.generateStudentReport(this, getSortCamps(), getFilterCamps(), getFilterString());
    }

}
