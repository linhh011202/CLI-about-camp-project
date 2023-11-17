package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

/** 
 * Represents an interface that takes in a student and a camp name, and returns a value of true or false based on
 * his registration details.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface ICheckRegistration {
    /**
     * Given a student name and a camp name, the implementor checks the registration details and returns a boolean value based 
     * on whether it is satisfied with the details or not.
     * @param studentName Name of the the student of interest.
     * @param campName Name of the camp of interest
     * @return returns True for satosfactory, returns False for unsatisfactory.
     */
    public boolean checkRegistration(String studentName, String campName);
}
