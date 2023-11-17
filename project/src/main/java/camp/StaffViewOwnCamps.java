package camp;

import enquiries.*;
import misc.*;
import registration.*;
import suggestions.*;
import user.*;

import java.util.ArrayList;


/** 
 * Represents a class that looks within it's associated camp database and prints all camp details for all the camps that
 * they are in charge of.
 * @author Soo Qi Yang
 * @author Teo Kai Xuan
 * @author Masagca Merwyn Louie Dumasis
 * @author Nguyen Phuong Linh
 * @author Tee Jeeng Yee
 * @version 1.0
 * @since 2023-11-17
*/
public class StaffViewOwnCamps implements IViewOwnCamps {
    /**
     * The Camp Database that this StaffViewOwnCamps manages.
     */
    private CampDataBase campDataBase;

    /**
     * Creates a new StaffViewOwnCamps with the given Camp Database.
     * The camp database will call this constructor and input itself as the parameter upon initialisation or a call to the static method in {@link CRDBInterfaceInitialiser}.
     * @param campDataBase This StaffViewOwnCamps's associated Camp Database.
     */
    public StaffViewOwnCamps(CampDataBase campDataBase) {
        this.campDataBase = campDataBase;
    }

    public void viewOwnCamps(User user, ISortCamps iSortCamps, IFilterCamps iFilterCamps, String filterString) {
        // Can potentially assert if user is staff here but shouldn't be needed!

        iSortCamps.sortCamps();// Sorts camps according to sorting set by user.
        iFilterCamps.filterCamps(filterString);// Filter camps according to filter set by user.

        ArrayList<Camp> allCamps = campDataBase.getAllCamps();

        // print staff's camps
        System.out.printf("List of camps created by you:\n");

        // If no camps
        if (allCamps.size() == 0) {
            System.out.printf("There are no camps to display!\n");
            return;
        }

        boolean noCamps = true;
        for (int i = 0; i < allCamps.size(); ++i) {
            // Print if camp is owned by staff, and is NOT filtered out.
            if (allCamps.get(i).getStaffInCharge().equals(user.getName()) && !allCamps.get(i).getIsFilteredOut()) {
                Camp curCamp = allCamps.get(i);
                curCamp.printCamp();
                noCamps = false;
            }
        }
        if (noCamps) {
            System.out.printf("There are no camps that you own to display!\n");
        }

    }
}
