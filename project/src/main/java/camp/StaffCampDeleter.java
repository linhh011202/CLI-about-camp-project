package camp;

import misc.*;
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
     * The camp database will call this constructor and input itself as the parameter upon initialisation or a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param campDataBase This StaffCampDeleter's associated Camp Database.
     */
    public StaffCampDeleter(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public boolean deleteCamp(User user, String campName) {
        // Find the campName that has the StaffName as in-charge for row of camps.
        // If cant find because of no such camp, or camp is under diff staff, return
        // false to indicate failure.
        ArrayList<Camp> allCamps = campDataBase.getAllCamps();

        for (int i = 0; i < allCamps.size(); ++i) {
            if (allCamps.get(i).getCampName().equals(campName)
                    && allCamps.get(i).getStaffInCharge().equals(user.getName())) {
                        if(allCamps.get(i).getTotalSlots()!=(allCamps.get(i).getAvailableAttendeeSlots()+allCamps.get(i).getAvailableCampComSlots()))
                        {
                            System.out.printf("Can't delete a camp if a student has already registered for camp!\n");
                            return false;
                        }
                allCamps.remove(i);
                System.out.printf("Successfully deleted camp!\n");
                return true;
            }
        }

        System.out.printf("Delete failed! Couldn't find camp!\n");
        return false;

    }
}