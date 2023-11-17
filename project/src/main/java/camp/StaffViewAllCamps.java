package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;


/** 
 * Represents a class that looks within it's associated camp database and prints all camp details that a staff is allowed
 * to see. Currently, a staff can view all camps in a database.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class StaffViewAllCamps implements IViewAllCamps {
     /**
     * The Camp Database that this StaffViewAllCamps manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new StaffViewAllCamps with the given Camp Database.
     * @param campDataBase This StaffViewAllCamps's associated Camp Database.
     */
    public StaffViewAllCamps(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public void viewAllCamps(User user, ISortCamps iSortCamps, IFilterCamps iFilterCamps, String filterString) {
        // Can potentially assert if user is staff here but shouldn't be needed!

        iSortCamps.sortCamps();// Sorts camps according to sorting set by user.
        iFilterCamps.filterCamps(filterString);// Sets the isFilteredOut flag in the camps in campDB.

        ArrayList<Camp> allCamps = campDataBase.getAllCamps();

        System.out.println("List of all camps:\n");
        boolean noCamps = true;
        for (int i = 0; i < allCamps.size(); ++i) {
            Camp curCamp = allCamps.get(i);
            if (!curCamp.getIsFilteredOut()) {
                curCamp.printCamp();
                noCamps = false;
            }
        }
        if (noCamps) {
            System.out.printf("There are no camps to display!\n");
        }
    }
}
