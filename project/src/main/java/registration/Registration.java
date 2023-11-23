package registration;

import java.io.Serializable;

/** 
 * Represents a Registration entry created in the registration database. A registration entry contains information related to the registration of a 
 * student to a camp, such as role, name of student, name of camp, and whether he has deregistered before.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class Registration implements Serializable
{
    /**
     * This Registration's student name.
     */
    private String studentName;

    /**
     * This Registration's camp name.
     */
    private String campName;
    /**
     * This Registration's student's role in the camp.
     */
    private String role;

    /**
     * This Registration's deregistered status.
     */
    private boolean deregistered;

    /**
     * Creates a new Registration with the given attributes. The deregistered flag is initially always set to false.
     * @param studentName This Registration's student name.
     * @param campName This Registration's camp name.
     * @param role This Registration's role.
     */
    Registration(String studentName, String campName, String role) {
        this.studentName = studentName;
        this.campName = campName;
        this.role = role;
        this.deregistered = false;
    }

    /**
     * Prints the details of a registration entry.
     */
    public void printRegistration() {
        System.out.printf("|| Camp Name: %s | Student Name: %s | Role: %s | Is this entry Deregistered: %b ||\n",
                campName, studentName, role, deregistered);
        return;
    }

    /**
     * Gets this Registration's student name.
     * @return This Registration's student name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Changes this Registration's student name.
     * @param studentName This Registration's new student name.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Gets this Registration's camp name.
     * @return This Registration's camp name.
     */
    public String getCampName() {
        return campName;
    }

    /**
     * Changes this Registration's camp name.
     * @param campName This Registration's new camp name.
     */
    public void setCampName(String campName) {
        this.campName = campName;
    }

    /**
     * Gets this Registration's role.
     * @return This Registration's role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Changes this Registration's role.
     * @param role This Registration's new role.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Get this Registration's deregistered status.
     * @return This Registration's deregistered status.
     */
    public boolean getDeregistered() {
        return deregistered;
    }

    /**
     * Changes this Registration's deregistered status.
     * @param deregistered This Registration's new deregistered status.
     */
    public void setDeregistered(boolean deregistered) {
        this.deregistered = deregistered;
    }
}
