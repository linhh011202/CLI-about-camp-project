package camp;

import java.util.ArrayList;

/** 
 * Represents an interface to check within a camp database, if a specific camp has clashing ongoing dates with 
 * a list of other camps within the database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public interface ICheckNoClash {
    /**
     * Checks a camp against a list of other camps within the associated camp database. If there are any clashing dates, false is returned.
     * If there are no clashing dates, true is returned.
     * @param campsRegistered The list of camps to check against
     * @param campToRegister The camp of interest to check if its dates clash against the list of camps.
     * @return True if no clashing dates, False if dates clash.
     */
    public boolean checkNoClash(ArrayList<String> campsRegistered, String campToRegister);
}