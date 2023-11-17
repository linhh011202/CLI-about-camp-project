package camp;

import registration.*;
import enquiries.*;
import misc.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents an interface that prints all the camp details and corresponding roles of a student, given his list of 
 * camps registered and his respective roles.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IPrintRegisteredCamps {
    //It prints the camps AND the roles, can consider making the name more specific.

    /**
     * Prints out a list of camp details and corresponding roles of a student, given his list of 
     * camps registered and his respective roles.
     * @param registeredCampsRoles List of camps that contains the camp name and corresponding role name.
     */
    public void printRegisteredCamps(ArrayList<ArrayList<String>> registeredCampsRoles);
}
