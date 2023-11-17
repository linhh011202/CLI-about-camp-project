package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

/** 
 * Represents an interface that takes in a student and a camp name, and deregisters the student in the registration database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IDeregisterCamp {
    /**
     * Sets the student's registration status to be deregistered. Classes that implement this interface can set certain
     * criteria to occur before a registration is successful, depending on what is desired. Classes that implement this method 
     * should simply print an error message and not register the student to indicate failure.
     * @param student Name of student to be deregistered.
     * @param campName Name of camp for student to be deregistered from.
     */
    public void deregisterCamp(Student student, String campName);
}