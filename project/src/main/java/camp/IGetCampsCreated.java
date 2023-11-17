package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;


/** 
 * Represents an interface to check and return the list of camps that a staff created, within a camp database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IGetCampsCreated {
    /**
     * Searches the camp database to return a list of camps that were created by the user.
     * @param staffName The name of the user wanting to find their list of camps created.
     * @return The String array of camp names that are owned by him under the associated camp database.
     */
    public ArrayList<String> getListCampStaffCreated(String staffName);
}
