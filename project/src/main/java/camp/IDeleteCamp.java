package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

/** 
 * Represents an interface to delete a camp within a camp database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IDeleteCamp {
    /**
     * Deletes a camp from within the associated camp database.
     * @param user The user that will delete the camp.
     * @param campName The name of the camp to be deleted.
     * @return Returns True on success, or False on error.
     */
    public boolean deleteCamp(User user, String campName);
}
