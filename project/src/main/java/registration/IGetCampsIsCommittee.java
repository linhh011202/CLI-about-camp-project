package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents an interface that returns all camp names that a student is a camp committee member of.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IGetCampsIsCommittee {
    /**
     * Creates an array of Strings containing the names of all the camps that a student is a camp committee member of. 
     * In the current implementation, the maxmimum number of camps a student can be a camp committee member of is one, so 
     * we should expect the returned array to have a maximum size of 1.
     * @param student The student of interest.
     * @return The array of strings generated that will include all the camp names that the student is a committee member of.
     */
    public ArrayList<String> getCampsIsCommittee(Student student);
}
