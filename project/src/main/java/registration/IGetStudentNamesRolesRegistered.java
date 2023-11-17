package registration;

import camp.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents an interface that returns an ArrayList of ArrayList of Strings containing all the students and their
 * corresponding roles in a given camp.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IGetStudentNamesRolesRegistered {
    /**
     * Creates an ArrayList of ArrayList of Strings that whos all students and their respective roles in a camp.
     * @param campName The camp to retrieve the list of students and their roles from.
     * @return ArrayList of ArrayList of Strings containing student names and corresponding roles for that camp.
     */
    public ArrayList<ArrayList<String>> getRegisteredStudentNamesRoles(String campName);
}
