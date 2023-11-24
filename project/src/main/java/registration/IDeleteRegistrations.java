package registration;

/** 
 * Represents an interface that enables the user to delete all registration entries for a specific camp in the implementor's associated registration database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface IDeleteRegistrations {

    /**
     * Deletes all registration entries for a specific camp in the implementor's associated registration database. Should only be called
     * after staff.DeleteCamp() returns true.
     * @param campName The name of the camp whose registration entries are to be deleted.
     */
    public void deleteRegistrations(String campName);
}
