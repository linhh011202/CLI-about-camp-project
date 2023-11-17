package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;

/** 
 * Represents a class that deletes a camp within the camp database associated with this StaffCampDeleter.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class StaffCampDeleter implements IDeleteCamp {
    /**
     * The Camp Database that this StaffCampDeleter manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new StaffCampDeleter with the given Camp Database.
     * @param campDataBase This StaffCampDeleter's associated Camp Database.
     */
    public StaffCampDeleter(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public boolean deleteCamp(User user, String campName) {
        // Possible error checking if its not a staff?? But dont think we need it since
        // there shouldn't be a place in the mainApp
        // where non-staffs can even call this func

        // Find the campName that has the StaffName as in-charge for row of camps.
        // If cant find because of no such camp, or camp is under diff staff, return
        // false to indicate failure.
        ArrayList<Camp> allCamps = campDataBase.getAllCamps();

        for (int i = 0; i < allCamps.size(); ++i) {
            if (allCamps.get(i).getCampName().equals(campName)
                    && allCamps.get(i).getStaffInCharge().equals(user.getName())) {
                allCamps.remove(i);
                return true;
            }
        }
        // (indicates failure to delete camp); Probably handled by mainAPP
        return false;

    }
}