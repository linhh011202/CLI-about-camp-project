package registration;

import java.util.ArrayList;

/** 
 * Represents an interface that returns all camp names that a student is registered in, and his respective roles.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IGetCampNamesRolesRegistered {
    /**
     * This method takes in a student name, and returns a ArrayList containing an ArrayList of strings, containing all the student's registered camps
     * and the corresponding roles.
     * @param studentName The student to obtain camps registered and roles for.
     * @return The ArrayList that contains the camp names and corresponding roles of the student.
     */
    public ArrayList<ArrayList<String>> getRegisteredCampNamesRoles(String studentName);
}
