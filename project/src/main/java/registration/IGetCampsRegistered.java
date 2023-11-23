package registration;

import java.util.ArrayList;

/** 
 * Represents an interface that returns all camp names that a student has registered in.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IGetCampsRegistered {
    /**
     * Creates an ArrayList of Strings that include all the camp names that a student of interest is registered in.
     * @param studentName The name of the student of interest.
     * @return An array of strings with all the camp names the student has registered in, regardless of role.
     */
    public ArrayList<String> getRegisteredCampNames(String studentName);
}
