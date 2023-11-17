package user;

import camp.*;
import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;

/** 
 * Represents a Camp Commitee member in the system. A Camp Committee member has more power than a Student, and can generate reports,
 * and contains a points variable.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class CampCommittee extends Student {
    private int points = 0;
    private String campName;

    /**
     * Generates a new Camp Committee object from an existing student object. This is usually called when a student registers to be a camp
     * committee member for a camp. 
     * @param student The student object to be promoted.
     * @param campName The camp name that the student will be a camp committee member of.
     */
    public CampCommittee(Student student, String campName) {
        // Uses copy constructor for superClass to copy everything in.
        super(student);
        super.setIsCommittee(true);
        this.campName = campName;
    }

    /**
     * Gets this Camp Committee's camp name that he is a camp committee of.
     * @return The name of the camp that this Camp Committee object is a camp committee member of.
     */
    public String getCampName() {
        return campName;
    }

    /**
     * Adds points to this Camp Commiteee object. Usually called by user database when this Camp Committee member successfully gets a 
     * suggestion accepted, or successfully replies an enquiry, or successfully gives a suggestion.
     */
    public void addPoints() {
        points++;
    }


    /**
     * Gets this Camp Committee's points.
     * @return This Camp Commitee's points.
     */
    public int getPoints() {
        return points;
    }

}